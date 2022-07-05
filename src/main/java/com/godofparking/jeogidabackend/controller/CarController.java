package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    // 유저가 가지고 있는 모든 차량 조회
    @GetMapping("/car/{user_id}")
    public List<CarDto> getCarList(@PathVariable Integer user_id) {
        return carService.getCarList(user_id);
    }

    // 차량 등록
    @PostMapping("/car/")
    public boolean save(@RequestBody CarDto carDto) {
        return carService.insertCar(carDto);
    }

    // 차량 정보 수정
    @PatchMapping("/car/{id}")
    public boolean updateCar(@PathVariable Integer id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }


    // 차량 삭제
    @DeleteMapping("/car/{user_id}/{id}")
    public boolean deleteCar(@PathVariable Integer user_id, @PathVariable Integer id) {
        return carService.deleteCar(user_id, id);
    }

}
