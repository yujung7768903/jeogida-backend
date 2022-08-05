package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.dto.LocationDto;
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

    @Override
    public List<FavoriteLocationDto> getFavoriteLocationList() {
        return favoriteLocationMapper.getFavoriteLocationList();
    }

    @Override
    public List<LocationDto> getFavoriteLocationById(Integer user_id) {
        log.info("Service: User Id: {}", user_id);
        return favoriteLocationMapper.getFavoriteLocationById(user_id);
    }

    @Override
    public boolean insertFavoriteLocation(Integer user_id, Integer location_id) {
        FavoriteLocationDto favoriteLocationDto = FavoriteLocationDto.builder()
                .user_id(user_id)
                .location_id(location_id)
                .build();

        try {
            favoriteLocationMapper.insertFavoriteLocation(favoriteLocationDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: e");
            return false;
        }
    }

    @Override
    public boolean deleteFavoriteLocation(Integer user_id, Integer location_id) {
        try {
            favoriteLocationMapper.deleteFavoriteLocation(user_id, location_id);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }
}
