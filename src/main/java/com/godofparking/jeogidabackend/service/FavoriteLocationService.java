package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.dto.LocationDto;

import java.util.List;

public interface FavoriteLocationService {
    public List<FavoriteLocationDto> getFavoriteLocationList();
    public List<LocationDto> getFavoriteLocationById(String user_code);
    public void insertFavoriteLocation(String user_code, Integer location_id);
    public void deleteFavoriteLocation(String user_code, Integer location_id);
}
