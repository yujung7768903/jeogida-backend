package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.mapper.ParkingInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingInfoImplement implements ParkingInfoService {
    private final ParkingInfoMapper parkingInfoMapper;

    // 모든 주차정보 조회
    @Override
    public List<ParkingInfoDto> getParkingInfoList() {
        return parkingInfoMapper.getParkingInfoList();
    }

    // 특정 id 주차정보 조회
    @Override
    public ParkingInfoDto getParkingInfo(Integer id) {
        return parkingInfoMapper.getParkingInfo(id);
    }

    // 주차 정보 추가
    @Override
    public boolean insertParkingInfo(ParkingInfoDto parkingInfoDto) {
        try {
            //시간 설정
            parkingInfoDto.setChanged_at(LocalDateTime.now());
            parkingInfoMapper.insertParkingInfo(parkingInfoDto);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 주차 정보 수정
    @Override
    public boolean updateParkingInfo(Integer id, ParkingInfoDto parkingInfoDto) {
        System.out.println("전: " + parkingInfoDto);
        parkingInfoDto.setId(id);
        System.out.println("후: " + parkingInfoDto);

        // 이전 주차정보 상태
        ParkingInfoDto before = new ParkingInfoDto();
        before = parkingInfoMapper.getParkingInfo(id);
        // 만약 이전과 주차상태가 변경되었다면
        if(before.getIs_parked() != parkingInfoDto.getIs_parked()){
            parkingInfoDto.setChanged_at(LocalDateTime.now());
        }

        try {
            parkingInfoMapper.updateParkingInfo(parkingInfoDto);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 주차 정보 삭제
    @Override
    public boolean deleteParkingInfo(Integer id) {
        try {
            parkingInfoMapper.deleteParkingInfo(id);
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

}
