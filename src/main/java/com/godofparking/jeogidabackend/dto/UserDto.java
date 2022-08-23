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

    @ApiModelProperty(example = "https://lh3.googleusercontent.com/a-/AFdZucpR_TN-i3qs-t0dQk-LFdHqSIUq_Wvv10iwcAIKSw=s96-c")
    private String photo_url;

    @ApiModelProperty(example = "104480857081468893438")
    private String code;


    @Builder
    public UserDto(Integer id, String email, String nickname, Role role, String photo_url, String code) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.photo_url = photo_url;
        this.code = code;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public UserDto update(String email, String nickname, String photo_url) {
        this.email = email;
        this.nickname = nickname;
        this.photo_url = photo_url;

        return this;
    }

    public UserDto update(String email, String nickname, Role role, String photo_url) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.photo_url = photo_url;

        return this;
    }


}
