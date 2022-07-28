package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"즐겨 찾는 차량"})
@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @ApiOperation(value = "모든 차량 조회")
    @GetMapping("/car")
    public List<CarDto> getCarList() {
        return carService.getCarList();
    }

    @ApiOperation(value = "유저가 즐겨찾는 모든 차량 조회")
    @ApiImplicitParam(name = "user_id", value = "유저 아이디(고유 식별 번호)", required = true)
    @GetMapping("/car/{user_id}")
    public List<CarDto> getCarById(@PathVariable Integer user_id) {
        return carService.getCarById(user_id);
    }

    @ApiOperation(value = "차량 등록")
    @PostMapping("/car")
    public boolean save(@RequestBody CarDto carDto) {
        return carService.insertCar(carDto);
    }

    @ApiOperation(value = "차량 정보 수정")
    @ApiImplicitParam(name = "id", value = "차량 아이디(고유 식별 번호)", required = true)
    @PatchMapping("/car/{id}")
    public boolean updateCar(@PathVariable Integer id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @ApiOperation(value = "차량 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "유저 아이디(고유 식별 번호)", required = true),
            @ApiImplicitParam(name = "id", value = "차량 아이디(고유 식별 번호)", required = true)
    })
    @DeleteMapping("/car/{user_id}/{id}")
    public boolean deleteCar(@PathVariable Integer user_id, @PathVariable Integer id) {
        return carService.deleteCar(user_id, id);
    }

}
