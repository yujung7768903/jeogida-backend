package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.MapDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.mapper.MapMapper;
import com.godofparking.jeogidabackend.mapper.ParkingLotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MapServiceImplement implements MapService {

    private final MapMapper mapMapper;

    // 모든 지도 조회
    @Override
    public List<MapDto> getMapList() {
        return mapMapper.getMapList();
    }

    // 특정 id 지도 조회
    @Override
    public MapDto getMap(Integer id) {
        return mapMapper.getMap(id);
    }

    // 주차장 추가
    @Override
    public boolean insertMap(MapDto mapDto) {
        try {
            mapMapper.insertMap(mapDto);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 지도 정보 수정
    @Override
    public boolean updateMap (Integer id, MapDto mapDto) {
        System.out.println("전: " + mapDto);
        mapDto.setId(id);
        System.out.println("후: " + mapDto);
        try {
            mapMapper.updateMap(mapDto);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 지도 삭제
    @Override
    public boolean deleteMap(Integer id) {
        try {
            mapMapper.deleteMap(id);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

}
