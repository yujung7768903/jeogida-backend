package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.PlaceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlaceMapper {
    public PlaceDto getPlaceByCar(Integer id);
}
