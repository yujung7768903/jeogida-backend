package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.MapDto;

import java.util.List;

public interface MapService {
    public List<MapDto> getMapList();

    public MapDto getMap(Integer id);

    public boolean insertMap(MapDto mapDto);

    public boolean updateMap(Integer id, MapDto mapDto);

    public boolean deleteMap(Integer id);

    public MapDto getMapByParkingLot(Integer id);
}
