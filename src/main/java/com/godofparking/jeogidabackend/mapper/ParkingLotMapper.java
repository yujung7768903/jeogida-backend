package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingLotMapper {
    public List<ParkingLotDto> getParkingLotList();
    public ParkingLotDto getParkingLot(Integer id);
    public int insertParkingLot(ParkingLotDto parkingLotDto);
    public int updateParkingLot(ParkingLotDto parkingLotDto);
    public int deleteParkingLot(Integer id);
}
