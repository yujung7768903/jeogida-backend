package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.MapDto;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface MapMapper {
    public List<MapDto> getMapList();
    public MapDto getMap(Integer id);
    public int insertMap(MapDto mapDto);
    public int updateMap(MapDto mapDto);
    public int deleteMap(Integer id);
}
