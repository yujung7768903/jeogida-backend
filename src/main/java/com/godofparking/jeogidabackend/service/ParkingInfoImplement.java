package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.config.auth.time.TimeGap;
import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingInfoUpdateRequestDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.exception.DuplicateException;
import com.godofparking.jeogidabackend.mapper.ParkingInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParkingInfoImplement implements ParkingInfoService {
    private final ParkingInfoMapper parkingInfoMapper;
    private final ParkingLotService parkingLotService;

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
    public void insertParkingInfo(ParkingInfoDto parkingInfoDto) {
        try {
            //시간 설정
            parkingInfoDto.setChanged_at(LocalDateTime.now());
            parkingInfoMapper.insertParkingInfo(parkingInfoDto);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    // 주차 정보 수정
    @Override
    public void updateParkingInfo(ParkingInfoUpdateRequestDto requestDto) {
        ParkingInfoDto parkingInfoDto = checkInfoByNumberAndParkingLotId(requestDto);

        // 만약 이전과 주차상태가 변경되었다면
        if (parkingInfoDto.getIs_parked() != requestDto.getIs_parked()) {
            parkingInfoDto.update(requestDto.getIs_parked());
            parkingInfoMapper.updateParkingInfo(parkingInfoDto);
            if (parkingInfoDto.getIs_parked() == true) { // 주차된 상태로 변경되었다면, 주차된 차량 수 증가
                parkingLotService.increaseParkedNum(parkingInfoDto.getParking_lot_id());
            } else {
                parkingLotService.decreaseParkedNum(parkingInfoDto.getParking_lot_id());
            }
        }
    }

    // 주차 정보 삭제
    @Override
    public boolean deleteParkingInfo(Integer id) {
        try {
            parkingInfoMapper.deleteParkingInfo(id);
            return true;
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            return false;
        }
    }

    // 주차시간 조회
    @Override
    public TimeGap getParkingTime(Integer id) {
        TimeGap timeGap = new TimeGap();
        ParkingInfoDto before = new ParkingInfoDto();
        before = parkingInfoMapper.getParkingInfo(id);
        LocalDateTime startTime = before.getChanged_at();
        LocalDateTime endTime = LocalDateTime.now();

        // 주차하지 않은 경우
        if (!before.getIs_parked()) {
            return timeGap;
        }
        // 주차한 경우
        else {
            timeGap.setHour((int) ChronoUnit.MINUTES.between(startTime, endTime) / 60);
            timeGap.setMinute((int) ChronoUnit.MINUTES.between(startTime, endTime) % 60);

            return timeGap;
        }
    }
    //자동차 id로 주차정보 확인
    public ParkingInfoDto getParkingInfoByCar(Integer car_id){
        return parkingInfoMapper.getParkingInfoByCar(car_id);
    };

    public ParkingInfoDto checkInfoByNumberAndParkingLotId(ParkingInfoUpdateRequestDto requestDto) {
        ParkingInfoDto parkingInfoDto = parkingInfoMapper.checkInfoByNumberAndParkingLotId(requestDto);

        if (parkingInfoDto == null) {
            throw new IllegalArgumentException("해당 number와 parking_lot_id를 가진 주차 공간은 존재하지 않습니다.");
        }

        return parkingInfoDto;
    }

    public void checkDuplicateParkingInfo(Integer number, Integer parking_lot_id) {
        ParkingInfoDto parkingInfoDto = parkingInfoMapper.checkDuplicateParkingInfo(number, parking_lot_id);

        if (parkingInfoDto != null) {
            throw new DuplicateException("동일한 주차 정보가 이미 존재합니다");
        }
    }

}
