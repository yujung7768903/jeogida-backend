package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImplement implements CarService{
    private final CarMapper carMapper;

    @Override
    public List<CarDto> getCarList(Integer user_id) {
        return carMapper.getCarList(user_id);
    }

    @Override
    public boolean insertCar(CarDto carDto) {
        try {
            carMapper.insertCar(carDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    @Override
    public boolean updateCar(Integer id, CarDto carDto) {
        carDto.setId(id);
        try {
            carMapper.updateCar(carDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    @Override
    public boolean deleteCar(Integer user_id, Integer id) {
        try {
            carMapper.deleteCar(user_id, id);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }
}
