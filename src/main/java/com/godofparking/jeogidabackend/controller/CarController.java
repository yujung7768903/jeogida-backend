package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.CarDto;
import com.godofparking.jeogidabackend.dto.CarSaveRequestDto;
import com.godofparking.jeogidabackend.dto.CarUpdateRequestDto;
import com.godofparking.jeogidabackend.service.CarService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @GetMapping("/car/{user_code}")
    public ResponseEntity<Object> getCarById(@PathVariable String user_code) {
        try {
            List<CarDto> carDtoList = carService.getCarByUserId(user_code);
            return ResponseEntity.status(200).body(carDtoList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "차량 등록")
    @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true)
    @ApiResponses({
            @ApiResponse(code = 201, message = "차량 등록 완료"),
            @ApiResponse(code = 400, message = "즐겨찾기에 해당 차량이 이미 존재합니다"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @PostMapping("/car/{user_code}")
    public ResponseEntity<String> save(@PathVariable String user_code, @Valid @RequestBody CarSaveRequestDto requestDto) {
        try {
            carService.insertCar(user_code, requestDto);
            return ResponseEntity.status(201).body("차량 등록 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "차량 정보 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true),
            @ApiImplicitParam(name = "id", value = "차량 아이디(고유 식별 번호)", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "차량 수정 완료"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @PatchMapping("/car/{user_code}/{id}")
    public ResponseEntity<String> updateCar(@PathVariable String user_code, @PathVariable Integer id, @Valid @RequestBody CarUpdateRequestDto requestDto) {
        try {
            carService.updateCar(user_code, id, requestDto);
            return ResponseEntity.status(200).body("차량 정보 수정 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "차량 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true),
            @ApiImplicitParam(name = "id", value = "차량 아이디(고유 식별 번호)", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "차량 삭제 완료"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @DeleteMapping("/car/{user_code}/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String user_code, @PathVariable Integer id) {
        try {
            carService.deleteCar(user_code, id);
            return ResponseEntity.status(200).body("차량 삭제 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
