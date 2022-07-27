package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.service.FavoriteLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "즐겨찾는 장소")
@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {
    private final FavoriteLocationService favoriteLocationService;

    @ApiOperation(value = "모든 장소 조회")
    @GetMapping("/favorite-location")
    public List<FavoriteLocationDto> getFavoriteLocationList() {
        return favoriteLocationService.getFavoriteLocationList();
    }

    @ApiOperation(value = "유저가 즐겨찾는 모든 장소 조회")
    @ApiImplicitParam(name = "user_id", value = "유저 아이디(고유 식별 번호)", required = true)
    @GetMapping("/favorite-location/{user_id}")
    public List<FavoriteLocationDto> getFavoriteLocationById(@PathVariable Integer user_id) {
        return favoriteLocationService.getFavoriteLocationById(user_id);
    }

    @ApiOperation(value = "즐겨찾는 장소 추가")
    @PostMapping("/favorite-location")
    public boolean insertFavoriteLocation(@RequestBody FavoriteLocationDto favoriteLocationDto) {
        return favoriteLocationService.insertFavoriteLocation(favoriteLocationDto);
    }

    @ApiOperation(value = "즐겨찾는 장소 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "유저 아이디(고유 식별 번호)", required = true),
            @ApiImplicitParam(name = "location_id", value = "장소 아이디(고유 식별 번호)", required = true)
    })
    @DeleteMapping("/favorite-location/{user_id}/{location_id}")
    public boolean deleteFavoriteLocation(@PathVariable Integer user_id, @PathVariable Integer location_id) {
        return favoriteLocationService.deleteFavoriteLocation(user_id, location_id);
    }
}
