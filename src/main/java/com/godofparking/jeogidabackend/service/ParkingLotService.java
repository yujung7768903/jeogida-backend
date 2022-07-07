package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.ParkingLotDto;

import java.util.List;

public interface ParkingLotService {
    public List<ParkingLotDto> getParkingLotList();

    public ParkingLotDto getParkingLot(Integer id);

    public boolean insertParkingLot(ParkingLotDto parkingLotDto);

    public boolean updateParkingLot(Integer id, ParkingLotDto parkingLotDto);

    public boolean deleteParkingLot(Integer id);
}
