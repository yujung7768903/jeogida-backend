package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.dto.ParkingLotSaveRequestDto;
import com.godofparking.jeogidabackend.exception.DuplicateParkingLotException;
import com.godofparking.jeogidabackend.mapper.ParkingLotMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParkingLotServiceImplement implements ParkingLotService{
    private final ParkingLotMapper parkingLotMapper;

    // 모든 주차장 조회
    @Override
    public List<ParkingLotDto> getParkingLotList() {
        return parkingLotMapper.getParkingLotList();
    }

    // 특정 id 주차장 조회
    @Override
    public ParkingLotDto getParkingLot(Integer id) {
        return parkingLotMapper.getParkingLot(id);
    }

    @Override
    public List<ParkingInfoDto> getInfoListByParkingLotId(Integer parking_lot_id) {
        return parkingLotMapper.getInfoListByParkingLotId(parking_lot_id);
    }

    // 주차장 추가
    @Override
    public void insertParkingLot(ParkingLotSaveRequestDto requestDto) {
        checkDuplicateParkingLot(requestDto);

        try {
            parkingLotMapper.insertParkingLot(requestDto.toParkingLot());
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    // 주차장 정보 수정
    @Override
    public boolean updateParkingLot(Integer id, ParkingLotDto parkingLotDto) {
        parkingLotDto.setId(id);

        try {
            parkingLotMapper.updateParkingLot(parkingLotDto);
            return true;
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public void increaseParkedNum(Integer id) {
        ParkingLotDto parkingLotDto = checkParkingLotById(id);

        parkingLotDto.increaseParkedNum();

        try {
            parkingLotMapper.updateParkingLot(parkingLotDto);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    @Override
    public void decreaseParkedNum(Integer id) {
        ParkingLotDto parkingLotDto = checkParkingLotById(id);

        parkingLotDto.decreaseParkedNum();

        try {
            parkingLotMapper.updateParkingLot(parkingLotDto);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    // 주차장 삭제
    @Override
    public boolean deleteParkingLot(Integer id) {
        try {
            parkingLotMapper.deleteParkingLot(id);
            return true;
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            return false;
        }
    }

    public void checkDuplicateParkingLot(ParkingLotSaveRequestDto requestDto) {
        ParkingLotDto parkingLotDto = parkingLotMapper.checkDuplicateParkingLot(requestDto.toParkingLot());

        if (parkingLotDto != null) {
            throw new DuplicateParkingLotException("동일한 주차장이 이미 존재합니다");
        }
    }

    public ParkingLotDto checkParkingLotById(Integer id) {
        ParkingLotDto parkingLotDto = parkingLotMapper.getParkingLot(id);

        if (parkingLotDto == null) {
            throw new IllegalArgumentException("해당 아이디를 가진 주차장은 존재하지 않습니다.");
        }

        return parkingLotDto;
    }

    // 특정 건물의 모든 주차장 조회
    @Override
    public List<ParkingLotDto> getParkingLotByLocation(Integer id) {
        return parkingLotMapper.getParkingLotByLocation(id);
    }

}
