package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ParkingInfoUpdateRequestDto {

    @ApiModelProperty(example = "1")
    @NotNull(message = "주차 공간의 번호는 빈 값을 가질 수 없습니다.")
    @Positive(message = "아이디는 0 또는 음수 값을 가질 수 없습니다.")
    private Integer number;

    @ApiModelProperty(example = "5")
    @NotNull(message = "주차장의 번호는 빈 값을 가질 수 없습니다.")
    @Positive(message = "아이디는 0 또는 음수 값을 가질 수 없습니다.")
    private Integer parking_lot_id;

    @NotNull(message = "주차 여부에 대한 정보는 빈 값을 가질 수 없습니다.")
    private Boolean is_parked;

}
