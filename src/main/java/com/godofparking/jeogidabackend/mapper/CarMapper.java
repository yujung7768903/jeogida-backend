package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.CarDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    public List<CarDto> getCarList();
    public List<CarDto> getCarById(Integer user_id);
    public int insertCar(CarDto carDto);
    public int updateCar(CarDto carDto);
    public int deleteCar(Integer user_id, Integer id);
}
