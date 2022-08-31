package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
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

    @Builder
    public CarDto(Integer id, String number, String name, Integer user_id) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.user_id = user_id;
    }

    public CarDto update(String number, String name) {
        this.number = number;
        this.name = name;

        return this;
    }
}
