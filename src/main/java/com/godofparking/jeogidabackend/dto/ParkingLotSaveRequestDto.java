package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ParkingLotSaveRequestDto {

    @NotBlank(message = "층 수 이름은 빈 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "B1")
    private String name;

    @NotNull(message = "장소 아이디는 빈 값을 가질 수 없습니다.")
    @Min(value = 1, message = "아이디는 0 또는 음수 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "1")
    private Integer location_id;

    @NotNull(message = "지도 아이디는 빈 값을 가질 수 없습니다.")
    @Min(value = 1, message = "아이디는 0 또는 음수 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "2")
    private Integer map_id;

    public ParkingLotDto toParkingLot() {
        return ParkingLotDto.builder()
                .name(name.toUpperCase())
                .location_id(location_id)
                .map_id(map_id)
                .build();
    }

}
