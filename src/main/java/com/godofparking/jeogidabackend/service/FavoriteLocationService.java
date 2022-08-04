package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.dto.LocationDto;

import java.util.List;

public interface FavoriteLocationService {
    public List<FavoriteLocationDto> getFavoriteLocationList();
    public List<LocationDto> getFavoriteLocationById(Integer user_id);
    public boolean insertFavoriteLocation(Integer user_id, Integer location_id);
    public boolean deleteFavoriteLocation(Integer user_id, Integer location_id);
}
