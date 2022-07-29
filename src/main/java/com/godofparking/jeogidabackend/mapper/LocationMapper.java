package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    public List<LocationDto> getLocationList();
    public List<ParkingLotDto> getParkingLotListByLocationId(Integer location_id);
    public int insertLocation(LocationDto locationDto);
    public int deleteLocation(Integer id);
    public int updateLocation(LocationDto locationDto);
}
