package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.mapper.FavoriteLocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FavoriteLocationImplement implements FavoriteLocationService{
    private final FavoriteLocationMapper favoriteLocationMapper;

    @Override
    public List<FavoriteLocationDto> getFavoriteLocationList(Integer user_id) {
        return favoriteLocationMapper.getFavoriteLocationList(user_id);
    }

    @Override
    public boolean insertFavoriteLocation(FavoriteLocationDto favoriteLocationDto) {
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
