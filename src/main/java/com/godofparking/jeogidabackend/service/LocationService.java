package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;

import java.util.List;

public interface LocationService {
    public List<LocationDto> getLocationList();
    public List<ParkingLotDto> getParkingLotListByLocationId(Integer location_id);
    public boolean insertLocation(LocationDto locationDto);
    public boolean updateLocation(Integer id, LocationDto locationDto);
    public boolean deleteLocation(Integer id);
}
