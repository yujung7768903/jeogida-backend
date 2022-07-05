package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteLocationMapper {
    public List<FavoriteLocationDto> getFavoriteLocationList(Integer user_id);
    public int insertFavoriteLocation(FavoriteLocationDto favoriteLocationDto);
    public int deleteFavoriteLocation(Integer user_id, Integer location_id);
}
