package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.config.auth.LoginUser;
import com.godofparking.jeogidabackend.config.auth.dto.SessionUser;
import com.godofparking.jeogidabackend.dto.LocationDto;
import com.godofparking.jeogidabackend.service.FavoriteLocationService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Api(tags = "즐겨찾는 장소")
@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {
    private final FavoriteLocationService favoriteLocationService;

    @ApiOperation(value = "유저가 즐겨찾는 모든 장소 조회")
    @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true)
    @GetMapping("/favorite-location/{user_code}")
    public List<LocationDto> getFavoriteLocationById(@PathVariable String user_code) {

        return favoriteLocationService.getFavoriteLocationById(user_code);
    }

    @ApiOperation(value = "즐겨찾는 장소 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location_id", value = "장소 아이디(고유 식별 번호)", required = true),
            @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "주차장 등록 완료"),
            @ApiResponse(code = 400, message = "즐겨찾기에 해당 주차장이 이미 존재합니다"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @PostMapping("/favorite-location/{user_code}/{location_id}")
    public ResponseEntity<String> insertFavoriteLocation(@PathVariable String user_code, @PathVariable Integer location_id) {
        try {
            favoriteLocationService.insertFavoriteLocation(user_code, location_id);
            return ResponseEntity.status(201).body("주차장 등록 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "즐겨찾는 장소 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location_id", value = "장소 아이디(고유 식별 번호)", required = true),
            @ApiImplicitParam(name = "user_code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "주차장 삭제 완료"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @DeleteMapping("/favorite-location/{user_code}/{location_id}")
    public ResponseEntity<String> deleteFavoriteLocation(@PathVariable String user_code, @PathVariable Integer location_id) {
        try {
            favoriteLocationService.deleteFavoriteLocation(user_code, location_id);
            return ResponseEntity.status(200).body("주차장 삭제 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
