package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FavoriteLocationDto {
    @ApiModelProperty(example = "2")
    private Integer id;

    @ApiModelProperty(example = "성신여자대학교")
    private Integer user_id;

    @ApiModelProperty(example = "2")
    private Integer location_id;
}
