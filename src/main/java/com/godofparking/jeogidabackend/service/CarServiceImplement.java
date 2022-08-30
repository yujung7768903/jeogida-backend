package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImplement implements CarService{
    private final CarMapper carMapper;
    private final UserService userService;

    @Override
    public List<CarDto> getCarList() {
        return carMapper.getCarList();
    }

    @Override
    public List<CarDto> getCarById(String user_code) {
        UserDto userDto = userService.getUser(user_code);

        return carMapper.getCarById(userDto.getId());
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
    public void deleteCar(String user_code, Integer id) {
        try {
            UserDto userDto = userService.getUser(user_code);
            carMapper.deleteCar(userDto.getId(), id);
        }catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
