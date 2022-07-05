package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;

import java.util.List;

public interface FavoriteLocationService {
    public List<FavoriteLocationDto> getFavoriteLocationList(Integer user_id);
    public boolean insertFavoriteLocation(FavoriteLocationDto favoriteLocationDto);
    public boolean deleteFavoriteLocation(Integer user_id, Integer location_id);
}
