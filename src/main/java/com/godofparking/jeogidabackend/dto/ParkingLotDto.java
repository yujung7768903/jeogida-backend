package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ParkingLotDto {
    @ApiModelProperty(example = "2")
    private Integer id;

    @ApiModelProperty(example = "5")
    private Integer number;

    @ApiModelProperty(example = "1")
    private Integer location_id;

    @ApiModelProperty(example = "1")
    private Integer map_id;
}