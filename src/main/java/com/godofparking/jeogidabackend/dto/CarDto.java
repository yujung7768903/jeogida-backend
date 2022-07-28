package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarDto {
    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "21다 3456")
    private String number;

    @ApiModelProperty(example = "car3")
    private String name;

    @ApiModelProperty(example = "1")
    private Integer user_id;
}
