package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.config.auth.time.TimeGap;
import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingInfoUpdateRequestDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.service.ParkingInfoService;
import com.godofparking.jeogidabackend.service.ParkingLotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "주차 유무 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/parkinginfo")
public class ParkingInfoController {
    private final ParkingInfoService parkingInfoService;

    @ApiOperation(value = "모든 주차 공간의 정보 조회")
    @GetMapping("")
    public List<ParkingInfoDto> getParkingInfoList() {
        return parkingInfoService.getParkingInfoList();
    }

    @ApiOperation(value = "아이디로 특정 주차공간 정보 조회")
    @GetMapping("/{id}")
    public ParkingInfoDto getParkingInfo(@PathVariable Integer id) {
        return parkingInfoService.getParkingInfo(id);
    }

    @ApiOperation(value = "주차 정보 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "주차 정보 등록 완료"),
            @ApiResponse(code = 400, message = "동일한 주차 정보가 이미 존재합니다")
    })
    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody ParkingInfoDto parkingInfoDto) {
        parkingInfoService.insertParkingInfo(parkingInfoDto);

        return ResponseEntity.status(200).body("주차 정보 등록 완료");
    }

    @ApiOperation(value = "주차 정보 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "주차 정보 수정 완료"),
            @ApiResponse(code = 404, message = "해당 number와 parking_lot_id를 가진 주차 공간은 존재하지 않습니다.")
    })
    @PatchMapping("")
    public ResponseEntity<String> updateParkingInfo(@Valid @RequestBody ParkingInfoUpdateRequestDto requestDto) {
        try {
            parkingInfoService.updateParkingInfo(requestDto);
            return ResponseEntity.status(200).body("주차 정보 수정 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "주차 정보 삭제")
    @DeleteMapping("{id}")
    public boolean deleteParkingInfo(@PathVariable Integer id) {
        return parkingInfoService.deleteParkingInfo(id);
    }

    @ApiOperation(value = "주차 시간 조회")
    @GetMapping("/time/{id}")
    public TimeGap getParkingTime(@PathVariable Integer id){
        return parkingInfoService.getParkingTime(id);
    }

    @ApiOperation(value = "차량정보로 주차정보 조회")
    @GetMapping("/car/{car_id}")
    public ParkingInfoDto getParkingInfoByCar(@PathVariable Integer car_id){
        return parkingInfoService.getParkingInfoByCar(car_id);
    }

}
