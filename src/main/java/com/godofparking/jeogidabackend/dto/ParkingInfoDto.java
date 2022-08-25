package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ParkingInfoDto {
    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "10")
    private Integer number;

    @ApiModelProperty(example = "true")
    private Boolean is_parked;

    @ApiModelProperty(example = "2020-01-01")
    private LocalDateTime changed_at;

    @ApiModelProperty(example = "2")
    private Integer parking_lot_id;

    @ApiModelProperty(example = "2")
    private Integer car_id;

    @Builder
    public ParkingInfoDto(Integer id, Integer number, Boolean is_parked, LocalDateTime changed_at, Integer parking_lot_id, Integer car_id) {
        this.id = id;
        this.number = number;
        this.is_parked = is_parked;
        this.changed_at = changed_at;
        this.parking_lot_id = parking_lot_id;
        this.car_id = car_id;
    }

    public ParkingInfoDto update(Boolean is_parked) {
        this.is_parked = is_parked;
        this.changed_at = LocalDateTime.now();

        if (!is_parked) { // 출차시 차량 삭제
            this.car_id = null;
        }

        return this;
    }

}
