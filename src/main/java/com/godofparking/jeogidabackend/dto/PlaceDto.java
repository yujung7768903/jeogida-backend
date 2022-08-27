package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlaceDto {

    // parking_lot 정보
    @ApiModelProperty(example = "2")
    private Integer parking_lot_id;

    @ApiModelProperty(example = "5")
    private String parking_lot_name;

    @ApiModelProperty(example = "4")
    private Integer parking_lot_total;

    @ApiModelProperty(example = "1")
    private Integer parking_lot_parked_num;

    // parking_info 정보
    @ApiModelProperty(example = "1")
    private Integer parking_info_id;

    @ApiModelProperty(example = "10")
    private Integer parking_info_number;

    @ApiModelProperty(example = "true")
    private Boolean parking_info_is_parked;

    @ApiModelProperty(example = "2020-01-01")
    private LocalDateTime parking_info_changed_at;

    // location 정보

    @ApiModelProperty(example = "1")
    private Integer location_id;

    @ApiModelProperty(example = "성신여자대학교")
    private String location_name;

    @ApiModelProperty(example = "2")
    private Integer location_total;

    // map 정보

    @ApiModelProperty(example = "1")
    private Integer map_id;

    @ApiModelProperty(example = "3층 주차장")
    private String map_name;

    @ApiModelProperty(example = "/path/232")
    private String map_path;


}
