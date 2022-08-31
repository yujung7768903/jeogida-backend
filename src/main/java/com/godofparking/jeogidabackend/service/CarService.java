package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.dto.CarSaveRequestDto;
import com.godofparking.jeogidabackend.dto.CarUpdateRequestDto;

import java.util.List;

public interface CarService {
    public List<CarDto> getCarList();
    public List<CarDto> getCarByUserId(String user_code);
    public void insertCar(String user_code, CarSaveRequestDto requestDto);
    public void updateCar(String user_code, Integer id, CarUpdateRequestDto requestDto);
    public void deleteCar(String user_code, Integer id);
}
