package com.godofparking.jeogidabackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String nickname;
    private String password;
    private Role role;

    @Builder
    public UserDto(String email, String nickname, String password, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
