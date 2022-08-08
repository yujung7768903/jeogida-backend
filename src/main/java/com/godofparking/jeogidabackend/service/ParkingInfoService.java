package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.config.auth.time.TimeGap;
import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingInfoService {
    public List<ParkingInfoDto> getParkingInfoList();

    public ParkingInfoDto getParkingInfo(Integer id);

    public boolean insertParkingInfo(ParkingInfoDto parkingInfoDto);

    public boolean updateParkingInfo(Integer id, ParkingInfoDto parkingInfoDto);

    public boolean deleteParkingInfo(Integer id);

    public TimeGap getParkingTime(Integer id);
}
