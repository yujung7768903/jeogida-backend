package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.dto.CarUpdateRequestDto;
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
    public List<CarDto> getCarByUserId(String user_code) {
        UserDto userDto = userService.getUser(user_code);

        return carMapper.getCarByUserId(userDto.getId());
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
    public void updateCar(String user_code, Integer id, CarUpdateRequestDto requestDto) {
        UserDto userDto = userService.getUser(user_code);
        CarDto carDto = checkCarByUserAndCarId(userDto.getId(), id);

        try {
            carDto = carDto.update(requestDto.getNumber(), requestDto.getName());
            carMapper.updateCar(carDto);
        }catch (Exception e) {
            System.out.println("error: " + e);
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

    public CarDto checkCarByUserAndCarId(Integer user_id, Integer id) {
        CarDto carDto = carMapper.getCarByUserAndCarId(user_id, id);

        if (carDto == null) {
            throw new IllegalArgumentException(id + "번은 해당 유저가 등록한 차량이 아닙니다.");
        }

        return carDto;
    }
}
