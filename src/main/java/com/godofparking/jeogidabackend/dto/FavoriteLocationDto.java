package com.godofparking.jeogidabackend.dto;

import lombok.Data;

@Data
public class FavoriteLocationDto {
    private Integer id;
    private Integer user_id;
    private Integer location_id;
}
