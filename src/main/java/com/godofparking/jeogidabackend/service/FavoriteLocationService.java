package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;

import java.util.List;

public interface FavoriteLocationService {
    public List<FavoriteLocationDto> getFavoriteLocationList();
    public List<FavoriteLocationDto> getFavoriteLocationById(Integer user_id);
    public boolean insertFavoriteLocation(FavoriteLocationDto favoriteLocationDto);
    public boolean deleteFavoriteLocation(Integer user_id, Integer location_id);
}
