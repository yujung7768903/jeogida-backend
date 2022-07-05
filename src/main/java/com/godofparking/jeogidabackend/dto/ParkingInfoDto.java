package com.godofparking.jeogidabackend.dto;

import lombok.Data;

@Data
public class ParkingInfoDto {
    private Integer id;

    private Integer number;

    private Boolean is_parked; // 0: 비어있음 1: 주차됨

    private Integer parking_lot_id;
}
