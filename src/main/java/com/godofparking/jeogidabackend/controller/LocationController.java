package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.dto.ParkingLotDto;
import com.godofparking.jeogidabackend.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "장소")
@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @ApiOperation(value = "모든 장소 조회")
    @GetMapping("/location")
    public List<LocationDto> getLocationList() {
        return locationService.getLocationList();
    }

    @ApiOperation(value = "장소에 있는 모든 주차장 조회")
    @GetMapping("/location/parkinglot/{location_id}")
    public List<ParkingLotDto> getParkingLotListByLocationId(@PathVariable Integer location_id) {
        return locationService.getParkingLotListByLocationId(location_id);
    }

    @ApiOperation(value = "장소 추가")
    @PostMapping("/location")
    public boolean insertLocation(@RequestBody LocationDto locationDto) {
        return locationService.insertLocation(locationDto);
    }

    @ApiOperation(value = "장소의 이름(name) 또는 주차장 수(total) 수정")
    @ApiImplicitParam(name = "id", value = "장소 아이디(고유 식별 번호)", required = true)
    @PatchMapping("/location/{id}")
    public boolean updateLocation(@PathVariable Integer id, @RequestBody LocationDto locationDto) {
        return locationService.updateLocation(id, locationDto);
    }

    @ApiOperation(value = "장소 삭제")
    @ApiImplicitParam(name = "id", value = "장소 아이디(고유 식별 번호)", required = true)
    @DeleteMapping("/location/{id}")
    public boolean deleteLocation(@PathVariable Integer id) {
        return locationService.deleteLocation(id);
    }
}
