package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.config.auth.LoginUser;
import com.godofparking.jeogidabackend.config.auth.dto.SessionUser;
import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.service.FavoriteLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Api(tags = "즐겨찾는 장소")
@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {
    private final FavoriteLocationService favoriteLocationService;
    private final HttpSession httpSession;

    @ApiOperation(value = "유저가 즐겨찾는 모든 장소 조회")
    @GetMapping("/favorite-location")
    public List<LocationDto> getFavoriteLocationById(@LoginUser SessionUser user) {

        return favoriteLocationService.getFavoriteLocationById(user.getId());
    }

    @ApiOperation(value = "즐겨찾는 장소 추가")
    @PostMapping("/favorite-location/{location_id}")
    @ApiImplicitParam(name = "location_id", value = "장소 아이디(고유 식별 번호)", required = true)
    public boolean insertFavoriteLocation(@PathVariable Integer location_id, @LoginUser SessionUser user) {

        return favoriteLocationService.insertFavoriteLocation(user.getId(), location_id);
    }

    @ApiOperation(value = "즐겨찾는 장소 삭제")
    @ApiImplicitParam(name = "location_id", value = "장소 아이디(고유 식별 번호)", required = true)
    @DeleteMapping("/favorite-location/{location_id}")
    public boolean deleteFavoriteLocation(@PathVariable Integer location_id, @LoginUser SessionUser user) {

        return favoriteLocationService.deleteFavoriteLocation(user.getId(), location_id);
    }
}
