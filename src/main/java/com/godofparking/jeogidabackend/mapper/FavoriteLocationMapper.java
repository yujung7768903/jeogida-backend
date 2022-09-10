package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.dto.LocationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteLocationMapper {
    public List<FavoriteLocationDto> getFavoriteLocationList();
    public List<LocationDto> getFavoriteLocationById(Integer user_id);
    public FavoriteLocationDto getFavoriteLocationByUserAndCarId(Integer user_id, Integer location_id);
    public int insertFavoriteLocation(FavoriteLocationDto favoriteLocationDto);
    public int deleteFavoriteLocation(FavoriteLocationDto favoriteLocationDto);
}
