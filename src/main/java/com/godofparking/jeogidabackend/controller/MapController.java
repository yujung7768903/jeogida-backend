package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.MapDto;
import com.godofparking.jeogidabackend.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    // 모든 지도 조회
    @GetMapping("")
    public List<MapDto> getMapList() {
        return mapService.getMapList();
    }

    // 아이디로 특정 지도 정보 조회
    @GetMapping("/{id}")
    public MapDto getMap(@PathVariable Integer id) {
        return mapService.getMap(id);
    }

    // 지도 등록
    @PostMapping("")
    public boolean save(@RequestBody MapDto mapDto) {
        return mapService.insertMap(mapDto);
    }

    // 지도 정보 수정
    @PatchMapping("/{id}")
    public boolean updateMap(@PathVariable Integer id, @RequestBody MapDto mapDto) {
        return mapService.updateMap(id, mapDto);
    }

    // 지도 삭제
    @DeleteMapping("{id}")
    public boolean deleteMap(@PathVariable Integer id) {
        return mapService.deleteMap(id);
    }
}
