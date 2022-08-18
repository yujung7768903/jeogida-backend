package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingInfoMapper {
    public List<ParkingInfoDto> getParkingInfoList();
    public ParkingInfoDto getParkingInfo(Integer id);
    public int insertParkingInfo(ParkingInfoDto parkingInfoDto);
    public int updateParkingInfo(ParkingInfoDto parkingInfoDto);
    public int deleteParkingInfo(Integer id);
    public ParkingInfoDto getParkingInfoByCar(Integer car_id);
}
