package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;

import java.util.List;

public interface CarService {
    public List<CarDto> getCarList();
    public List<CarDto> getCarById(Integer user_id);
    public boolean insertCar(CarDto carDto);
    public boolean updateCar(Integer id, CarDto carDto);
    public boolean deleteCar(Integer user_id, Integer id);
}
