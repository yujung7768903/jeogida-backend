package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class ParkingLotDto {
    @ApiModelProperty(example = "2")
    private Integer id;

    @ApiModelProperty(example = "5")
    private String name;

    @ApiModelProperty(example = "1")
    private Integer location_id;

    @ApiModelProperty(example = "1")
    private Integer map_id;

    @Builder
    public ParkingLotDto(Integer id, String name, Integer location_id, Integer map_id) {
        this.id = id;
        this.name = name;
        this.location_id = location_id;
        this.map_id = map_id;
    }
}