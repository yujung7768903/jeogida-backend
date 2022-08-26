package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.ParkingInfoDto;
import com.godofparking.jeogidabackend.dto.PlaceDto;
import com.godofparking.jeogidabackend.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "모든 주차정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @ApiOperation(value = "차량 아이디로 모든 주차정보 조회")
    @GetMapping("/{id}")
    public PlaceDto getPlaceByCar(@PathVariable Integer id) {
        return placeService.getPlaceByCar(id);
    }
}
