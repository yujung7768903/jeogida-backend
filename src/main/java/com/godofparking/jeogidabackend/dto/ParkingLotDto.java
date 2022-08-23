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

    @ApiModelProperty(example = "4")
    private Integer total;

    @ApiModelProperty(example = "1")
    private Integer parked_num;

    @Builder
    public ParkingLotDto(Integer id, String name, Integer location_id, Integer map_id, Integer total, Integer parked_num) {
        this.id = id;
        this.name = name;
        this.location_id = location_id;
        this.map_id = map_id;
        this.total = total;
        this.parked_num = parked_num;
    }
}