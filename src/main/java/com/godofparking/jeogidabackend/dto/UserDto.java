package com.godofparking.jeogidabackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String nickname;
    private Role role;

    @Builder
    public UserDto(Integer id, String email, String nickname, Role role) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
