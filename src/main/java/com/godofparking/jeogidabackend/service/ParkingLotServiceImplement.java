package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.mapper.ParkingLotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingLotServiceImplement implements ParkingLotService{
    private final ParkingLotMapper parkingLotMapper;

    // 모든 주차장 조회
    @Override
    public List<ParkingLotDto> getParkingLotList() {
        return parkingLotMapper.getParkingLotList();
    }

    @Override
    public ParkingLotDto getParkingLot(Integer id) {
        return parkingLotMapper.getParkingLot(id);
    }

    // 주차장 추가
    @Override
    public boolean insertParkingLot(ParkingLotDto parkingLotDto) {
        try {
            parkingLotMapper.insertParkingLot(parkingLotDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 주차장 정보 수정
    @Override
    public boolean updateParkingLot(Integer id, ParkingLotDto parkingLotDto) {
        System.out.println("전: " + parkingLotDto);
        parkingLotDto.setId(id);
        System.out.println("후: " + parkingLotDto);
        try {
            parkingLotMapper.updateParkingLot(parkingLotDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 주차장 삭제
    @Override
    public boolean deleteParkingLot(Integer id) {
        try {
            parkingLotMapper.deleteParkingLot(id);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

}
