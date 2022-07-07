package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    // 모든 장소 조회
    @GetMapping("/location")
    public List<LocationDto> getLocationList() {
        return locationService.getLocationList();
    }

    // 장소 추가
    @PostMapping("/location")
    public boolean insertLocation(@RequestBody LocationDto locationDto) {
        return locationService.insertLocation(locationDto);
    }

    // 장소 수정 (이름(name) 또는 주차장 수(total))
    @PatchMapping("/location/{id}")
    public boolean updateLocation(@PathVariable Integer id, @RequestBody LocationDto locationDto) {
        return locationService.updateLocation(id, locationDto);
    }

    // 장소 삭제
    @DeleteMapping("/location/{id}")
    public boolean deleteLocation(@PathVariable Integer id) {
        return locationService.deleteLocation(id);
    }
}
