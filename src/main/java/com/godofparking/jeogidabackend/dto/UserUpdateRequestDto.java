package com.godofparking.jeogidabackend.dto;

import com.godofparking.jeogidabackend.validation.NullOrNotBlank;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class UserUpdateRequestDto {

    @NullOrNotBlank
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @ApiModelProperty(example = "yj06283l4@gmail.com")
    private String email;

    @NullOrNotBlank
    @ApiModelProperty(example = "김유정")
    private String nickname;

    @NullOrNotBlank
    @ApiModelProperty(example = "https://lh3.googleusercontent.com/a-/AFdZucpR_TN-i3qs-t0dQk-LFdHqSIUq_Wvv10iwcAIKSw=s96-c")
    private String photo_url;

}
