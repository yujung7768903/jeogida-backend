package com.godofparking.jeogidabackend.dto;

import com.godofparking.jeogidabackend.validation.NullOrNotBlank;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarUpdateRequestDto {

    @NullOrNotBlank
    @ApiModelProperty(example = "21다 3456")
    private String number;

    @NullOrNotBlank
    @ApiModelProperty(example = "car3")
    private String name;

}
