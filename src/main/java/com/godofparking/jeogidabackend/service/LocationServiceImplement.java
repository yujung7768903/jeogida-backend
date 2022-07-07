package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationServiceImplement implements LocationService{
    private final LocationMapper locationMapper;

    @Override
    public List<LocationDto> getLocationList() {
        return locationMapper.getLocationList();
    }

    @Override
    public boolean insertLocation(LocationDto locationDto) {
        try {
            locationMapper.insertLocation(locationDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    @Override
    public boolean updateLocation(Integer id, LocationDto locationDto) {
        locationDto.setId(id);
        try {
            locationMapper.updateLocation(locationDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    @Override
    public boolean deleteLocation(Integer id) {
        try {
            locationMapper.deleteLocation(id);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

}
