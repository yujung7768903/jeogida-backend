package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.service.CarService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = CarDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @GetMapping("/car/{user_code}")
    public ResponseEntity<Object> getCarById(@PathVariable String user_code) {
        try {
            List<CarDto> carDtoList = carService.getCarById(user_code);
            return ResponseEntity.status(200).body(carDtoList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
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
            @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true),
            @ApiImplicitParam(name = "id", value = "차량 아이디(고유 식별 번호)", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "차량 삭제 완료"),
            @ApiResponse(code = 400, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @DeleteMapping("/car/{user_code}/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String user_code, @PathVariable Integer id) {
        try {
            carService.deleteCar(user_code, id);
            return ResponseEntity.status(200).body("차량 삭제 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
