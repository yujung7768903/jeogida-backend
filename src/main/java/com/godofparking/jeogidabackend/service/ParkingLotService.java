package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.dto.ParkingLotSaveRequestDto;

import java.util.List;

public interface ParkingLotService {
    public List<ParkingLotDto> getParkingLotList();

    public ParkingLotDto getParkingLot(Integer id);

    public List<ParkingInfoDto> getInfoListByParkingLotId(Integer parking_lot_id);

    public void insertParkingLot(ParkingLotSaveRequestDto requestDto);

    public boolean updateParkingLot(Integer id, ParkingLotDto parkingLotDto);

    public void increaseParkedNum(Integer id);

    public void decreaseParkedNum(Integer id);

    public boolean deleteParkingLot(Integer id);

    public List<ParkingLotDto> getParkingLotByLocation(Integer id);
}
