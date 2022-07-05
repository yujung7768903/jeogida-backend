package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.FavoriteLocationDto;
import com.godofparking.jeogidabackend.service.FavoriteLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {
    private final FavoriteLocationService favoriteLocationService;

    // 유저가 즐겨찾는 모든 장소 조회
    @GetMapping("/favorite-location/{user_id}")
    public List<FavoriteLocationDto> getFavoriteLocationList(@PathVariable Integer user_id) {
        return favoriteLocationService.getFavoriteLocationList(user_id);
    }

    // 즐겨찾는 장소 추가
    @PostMapping("/favorite-location")
    public boolean insertFavoriteLocation(@RequestBody FavoriteLocationDto favoriteLocationDto) {
        return favoriteLocationService.insertFavoriteLocation(favoriteLocationDto);
    }

    // 즐겨찾는 장소 삭제
    @DeleteMapping("/favorite-location/{user_id}/{location_id}")
    public boolean deleteFavoriteLocation(@PathVariable Integer user_id, @PathVariable Integer location_id) {
        return favoriteLocationService.deleteFavoriteLocation(user_id, location_id);
    }
}
