package com.godofparking.jeogidabackend.dto;

import com.godofparking.jeogidabackend.validation.NullOrNotBlank;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CarSaveRequestDto {

    @NotBlank(message = "차량 번호는 빈 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "21다 3456")
    private String number;

    @NotBlank(message = "차량 이름은 빈 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "car3")
    private String name;

    public CarDto toCar(Integer user_id) {
        return CarDto.builder()
                .number(number)
                .name(name)
                .user_id(user_id)
                .build();
    }

}
