package com.godofparking.jeogidabackend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserSaveRequestDto {

    @NotBlank(message = "이메일은 빈 값을 가질 수 없습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @ApiModelProperty(example = "yj06283l4@gmail.com")
    private String email;

    @NotBlank(message = "이름은 빈 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "김유정")
    private String nickname;

    @ApiModelProperty(example = "https://lh3.googleusercontent.com/a-/AFdZucpR_TN-i3qs-t0dQk-LFdHqSIUq_Wvv10iwcAIKSw=s96-c")
    private String photo_url;

    @NotBlank(message = "코드는 빈 값을 가질 수 없습니다.")
    @ApiModelProperty(example = "104480857081468893438")
    private String code;

    public UserDto toUser() {
        return UserDto.builder()
                .email(email)
                .nickname(nickname)
                .role(Role.USER)
                .photo_url(photo_url)
                .code(code)
                .build();
    }

}
