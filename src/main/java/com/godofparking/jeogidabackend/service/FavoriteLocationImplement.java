package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.exception.DuplicateException;
import com.godofparking.jeogidabackend.mapper.FavoriteLocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FavoriteLocationImplement implements FavoriteLocationService{
    private final FavoriteLocationMapper favoriteLocationMapper;
    private final UserService userService;

    @Override
    public List<FavoriteLocationDto> getFavoriteLocationList() {
        return favoriteLocationMapper.getFavoriteLocationList();
    }

    @Override
    public List<LocationDto> getFavoriteLocationById(String user_code) {
        UserDto userDto = userService.getUser(user_code);

        return favoriteLocationMapper.getFavoriteLocationById(userDto.getId());
    }

    @Override
    public void insertFavoriteLocation(String user_code, Integer location_id) {
        UserDto userDto = userService.getUser(user_code);
        checkDuplicateLocation(userDto.getId(), location_id);
        FavoriteLocationDto favoriteLocationDto = FavoriteLocationDto.builder()
                .user_id(userDto.getId())
                .location_id(location_id)
                .build();

        try {
            favoriteLocationMapper.insertFavoriteLocation(favoriteLocationDto);
        }catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    @Override
    public void deleteFavoriteLocation(String user_code, Integer location_id) {
        UserDto userDto = userService.getUser(user_code);
        FavoriteLocationDto favoriteLocationDto = checkLocationByUserAndLocationId(userDto.getId(), location_id);

        try {
            favoriteLocationMapper.deleteFavoriteLocation(favoriteLocationDto);
        }catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    public FavoriteLocationDto checkLocationByUserAndLocationId(Integer user_id, Integer location_id) {
        FavoriteLocationDto favoriteLocationDto = favoriteLocationMapper.getFavoriteLocationByUserAndCarId(user_id, location_id);

        if (favoriteLocationDto == null) {
            throw new IllegalArgumentException(location_id + "번은 해당 유저가 등록한 주차장이 아닙니다.");
        }

        return favoriteLocationDto;
    }

    public void checkDuplicateLocation(Integer user_id, Integer location_id) {
        FavoriteLocationDto favoriteLocationDto = favoriteLocationMapper.getFavoriteLocationByUserAndCarId(user_id, location_id);

        if (favoriteLocationDto != null) {
            throw new DuplicateException("즐겨찾기에 해당 주차장이 이미 존재합니다");
        }
    }

}
