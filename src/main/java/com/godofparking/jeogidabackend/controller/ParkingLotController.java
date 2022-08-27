package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.dto.ParkingLotSaveRequestDto;
import com.godofparking.jeogidabackend.exception.DuplicateParkingLotException;
import com.godofparking.jeogidabackend.service.ParkingLotService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "장소의 주차장 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    @ApiOperation(value = "모든 주차장 정보 조회")
    @GetMapping("")
    public List<ParkingLotDto> getParkingLotList() {
        return parkingLotService.getParkingLotList();
    }

    @ApiOperation(value = "주차장 아이디로 특정 주차장 정보 조회")
    @ApiImplicitParam(name = "id", value = "주차장 아이디(공간 아이디 아님. 주차장의 고유 식별 번호)", required = true)
    @GetMapping("/{id}")
    public ParkingLotDto getParkingLot(@PathVariable Integer id) {
        return parkingLotService.getParkingLot(id);
    }

    @ApiOperation(value = "주차장 아이디로 주차장에 있는 모든 주차공간의 차량 유무에 대한 정보 조회")
    @GetMapping("/parkinginfo/{parking_lot_id}")
    public List<ParkingInfoDto> getInfoListByParkingLotId(@PathVariable Integer parking_lot_id) {
        return parkingLotService.getInfoListByParkingLotId(parking_lot_id);
    }

    @ApiOperation(value = "주차장 등록", notes = "name은 주차장 층수에 해당. 지하는 앞에 B, 지상은 뒤에 F 붙여서 층 수 표현(소문자, 대문자 상관 없음). e.g. B2, B1, 1F, 2F.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "주차장 등록 완료"),
            @ApiResponse(code = 400, message = "동일한 주차장이 이미 존재합니다")
    })
    @PostMapping("")
    public ResponseEntity<String> save(@Valid @RequestBody ParkingLotSaveRequestDto requestDto) {
        try {
            parkingLotService.insertParkingLot(requestDto);
            return ResponseEntity.status(201).body("주차장 등록 완료");
        } catch (DuplicateParkingLotException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @ApiOperation(value = "주차장 정보 수정")
    @ApiImplicitParam(name = "id", value = "주차장 아이디(공간 아이디 아님. 주차장의 고유 식별 번호)", required = true)
    @PatchMapping("/{id}")
    public boolean updateParkingLot(@PathVariable Integer id, @RequestBody ParkingLotDto parkingLotDto) {
        return parkingLotService.updateParkingLot(id, parkingLotDto);
    }

    @ApiOperation(value = "주차장 삭제")
    @ApiImplicitParam(name = "id", value = "주차장 아이디(공간 아이디 아님. 주차장의 고유 식별 번호)", required = true)
    @DeleteMapping("{id}")
    public boolean deleteParkingLot(@PathVariable Integer id) {
        return parkingLotService.deleteParkingLot(id);
    }

    @ApiOperation(value = "특정 건물의 주차장 정보 조회")
    @GetMapping("/location/{id}")
    public List<ParkingLotDto> getParkingLotByLocation(Integer id) {
        return parkingLotService.getParkingLotByLocation(id);
    }
}
