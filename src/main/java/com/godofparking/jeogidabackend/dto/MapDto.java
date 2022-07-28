package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MapDto {
    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "3층 주차장")
    private String name;

    @ApiModelProperty(example = "/path/232")
    private String path;
}
