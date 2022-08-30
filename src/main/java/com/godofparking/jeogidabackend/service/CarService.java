package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;

import java.util.List;

public interface CarService {
    public List<CarDto> getCarList();
    public List<CarDto> getCarById(String user_code);
    public boolean insertCar(CarDto carDto);
    public boolean updateCar(Integer id, CarDto carDto);
    public void deleteCar(String user_code, Integer id);
}
