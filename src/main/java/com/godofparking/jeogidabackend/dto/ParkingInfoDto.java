package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ParkingInfoDto {
    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "10")
    private Integer number;

    @ApiModelProperty(example = "true")
    private Boolean is_parked;

    @ApiModelProperty(example = "2")
    private Integer parking_lot_id;
}
