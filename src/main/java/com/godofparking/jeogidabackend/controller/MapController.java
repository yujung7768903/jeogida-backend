package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.MapDto;
import com.godofparking.jeogidabackend.service.MapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "주차장 지도")
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    @ApiOperation(value = "모든 지도 조회")
    @GetMapping("")
    public List<MapDto> getMapList() {
        return mapService.getMapList();
    }

    @ApiOperation(value = "아이디로 특정 지도 정보 조회")
    @ApiImplicitParam(name = "id", value = "지도 아이디(고유 식별 번호)", required = true)
    @GetMapping("/{id}")
    public MapDto getMap(@PathVariable Integer id) {
        return mapService.getMap(id);
    }

    @ApiOperation(value = "지도 등록")
    @PostMapping("")
    public boolean save(@RequestBody MapDto mapDto) {
        return mapService.insertMap(mapDto);
    }

    @ApiOperation(value = "지도 정보 수정")
    @ApiImplicitParam(name = "id", value = "지도 아이디(고유 식별 번호)", required = true)
    @PatchMapping("/{id}")
    public boolean updateMap(@PathVariable Integer id, @RequestBody MapDto mapDto) {
        return mapService.updateMap(id, mapDto);
    }

    @ApiOperation(value = "지도 삭제")
    @ApiImplicitParam(name = "id", value = "지도 아이디(고유 식별 번호)", required = true)
    @DeleteMapping("{id}")
    public boolean deleteMap(@PathVariable Integer id) {
        return mapService.deleteMap(id);
    }
}
