package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    @ApiModelProperty(example = "4")
    private Integer id;

    @ApiModelProperty(example = "yj06283l4@gmail.com")
    private String email;

    @ApiModelProperty(example = "김유정")
    private String nickname;

    @ApiModelProperty(example = "USER")
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
