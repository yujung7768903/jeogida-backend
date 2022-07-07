package com.godofparking.jeogidabackend.dto;

import lombok.Data;

@Data
public class ParkingLotDto {
    private Integer id;

    private Integer number;

    private Integer location_id;

    private Integer map_id;
}