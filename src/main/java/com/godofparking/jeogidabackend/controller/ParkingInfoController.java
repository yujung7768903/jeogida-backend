package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.service.ParkingInfoService;
import com.godofparking.jeogidabackend.service.ParkingLotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public boolean save(@RequestBody ParkingInfoDto parkingInfoDto) {
        return parkingInfoService.insertParkingInfo(parkingInfoDto);
    }

    @ApiOperation(value = "주차 정보 수정")
    @PatchMapping("/{id}")
    public boolean updateParkingInfo(@PathVariable Integer id, @RequestBody ParkingInfoDto parkingInfoDto) {
        return parkingInfoService.updateParkingInfo(id, parkingInfoDto);
    }

    @ApiOperation(value = "주차 정보 삭제")
    @DeleteMapping("{id}")
    public boolean deleteParkingInfo(@PathVariable Integer id) {
        return parkingInfoService.deleteParkingInfo(id);
    }
}
