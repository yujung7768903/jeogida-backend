package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    // 모든 주차장 조회
    @GetMapping("")
    public List<ParkingLotDto> getParkingLotList() {
        return parkingLotService.getParkingLotList();
    }

    // 아이디로 특정 주차장 정보 조회
    @GetMapping("/{id}")
    public ParkingLotDto getParkingLot(@PathVariable Integer id) {
        return parkingLotService.getParkingLot(id);
    }

    // 주차장 등록
    @PostMapping("")
    public boolean save(@RequestBody ParkingLotDto parkingLotDto) {
        return parkingLotService.insertParkingLot(parkingLotDto);
    }

    // 주차장 정보 수정
    @PatchMapping("/{id}")
    public boolean updateParkingLot(@PathVariable Integer id, @RequestBody ParkingLotDto parkingLotDto) {
        return parkingLotService.updateParkingLot(id, parkingLotDto);
    }

    // 주차장 삭제
    @DeleteMapping("{id}")
    public boolean deleteParkingLot(@PathVariable Integer id) {
        return parkingLotService.deleteParkingLot(id);
    }
}
