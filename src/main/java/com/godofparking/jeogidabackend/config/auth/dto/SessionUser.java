package com.godofparking.jeogidabackend.config.auth.dto;

import com.godofparking.jeogidabackend.dto.Role;
import com.godofparking.jeogidabackend.dto.UserDto;
import lombok.Getter;

@Getter
public class SessionUser {
    private Integer id;
    private String nickname;
    private String email;
    private Role role;

    public SessionUser(UserDto userDto) {
        this.id = userDto.getId();
        this.nickname = userDto.getNickname();
        this.email = userDto.getEmail();
        this.role = userDto.getRole();
    }
}
