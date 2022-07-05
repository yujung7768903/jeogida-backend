package com.godofparking.jeogidabackend.dto;

import lombok.Data;

@Data
public class CarDto {
    private Integer id;
    private String number;
    private String name;
    private Integer user_id;
}
