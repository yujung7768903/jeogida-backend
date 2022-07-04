package com.godofparking.jeogidabackend.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String nickname;
    private String password;
}
