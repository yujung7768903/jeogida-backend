package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.MapDto;
import com.godofparking.jeogidabackend.service.MapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
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

//    @ApiOperation(value = "아이디로 특정 지도 정보 조회")
//    @ApiImplicitParam(name = "id", value = "지도 아이디(고유 식별 번호)", required = true)
//    @GetMapping("/{id}")
//    public MapDto getMap(@PathVariable Integer id) {
//        return mapService.getMap(id);
//    }

    @ApiOperation(value = "주차장 아이디로 특정 지도 정보 조회")
    @ApiImplicitParam(name = "parking_lot_id", value = "주차장 아이디(고유 식별 번호)", required = true)
    @GetMapping("/{parking_lot_id}")
    public void getMapByParkingLotId(@PathVariable Integer parking_lot_id, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("http://ec2-3-37-217-255.ap-northeast-2.compute.amazonaws.com:8081/" + parking_lot_id);
        } catch (IOException e) {
            log.error("요청을 처리하는 과정에서 오류가 발생했습니다: {}", e);
        }
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
