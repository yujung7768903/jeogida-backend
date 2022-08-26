package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.PlaceDto;
import com.godofparking.jeogidabackend.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlaceServiceImplement implements PlaceService{

    private final PlaceMapper placeMapper;

    public PlaceDto getPlaceByCar(Integer id){
        return placeMapper.getPlaceByCar(id);
    }
}
