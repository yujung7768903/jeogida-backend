package com.godofparking.jeogidabackend.config.auth.dto;

import com.godofparking.jeogidabackend.dto.UserDto;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserDto userDto) {
        this.name = userDto.getNickname();
        this.email = userDto.getEmail();
    }
}
