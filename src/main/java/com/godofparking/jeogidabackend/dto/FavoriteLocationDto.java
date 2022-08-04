package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class FavoriteLocationDto {
    @ApiModelProperty(example = "2")
    private Integer id;

    @ApiModelProperty(example = "4")
    private Integer user_id;

    @ApiModelProperty(example = "2")
    private Integer location_id;

    @Builder
    public FavoriteLocationDto(Integer user_id, Integer location_id) {
        this.user_id = user_id;
        this.location_id = location_id;
    }
}
