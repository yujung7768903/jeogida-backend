package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
