package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationDto {
    @ApiModelProperty(example = "2")
    private Integer id;

    @ApiModelProperty(example = "성신여자대학교")
    private String name;

    @ApiModelProperty(example = "2")
    private Integer total;
}
