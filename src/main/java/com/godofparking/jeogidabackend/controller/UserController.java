package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.dto.UserSaveRequestDto;
import com.godofparking.jeogidabackend.dto.UserUpdateRequestDto;
import com.godofparking.jeogidabackend.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"유저"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "모든 유저 조회")
    @GetMapping("/user/all")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation(value = "코드로 특정 유저 정보 조회")
    @ApiImplicitParam(name = "code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @GetMapping("/user/{code}")
    public ResponseEntity<Object> getUser(@PathVariable String code) {
        try {
            UserDto userDto = userService.getUser(code);
            return ResponseEntity.status(200).body(userDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "이메일로 특정 유저 정보 조회")
    @ApiImplicitParam(name = "email", value = "유저 이메일", required = true)
    @GetMapping("/user/id/{email}")
    public Integer getIdByEmail(@PathVariable String email) {
        return userService.findByEmail(email).getId();
    }

    @ApiOperation(value = "유저 등록")
    @ApiResponses({
            @ApiResponse(code = 201, message = "유저 등록 완료"),
            @ApiResponse(code = 400, message = "해당 코드를 가진 유저가 이미 존재합니다.")
    })
    @PostMapping("/user")
    public ResponseEntity<String> save(@Valid @RequestBody UserSaveRequestDto requestDto) {
        userService.insertUser(requestDto);

        return ResponseEntity.status(201).body("유저 등록 완료");
    }

    @ApiOperation(value = "유저 정보 수정")
    @ApiImplicitParam(name = "code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 404, message = "해당 코드를 가진 유저는 존재하지 않습니다.")
    })
    @PatchMapping("/user/{code}")
    public ResponseEntity<String> updateUser(@PathVariable String code, @Valid @RequestBody UserUpdateRequestDto requestDto) {
        try {
            userService.updateUser(code, requestDto);
            return ResponseEntity.status(200).body("유저 정보 수정 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "탈퇴하기")
    @ApiImplicitParam(name = "code", value = "구글 로그인 후 반환되는 데이터 중 id에 해당하는 값")
    @DeleteMapping("/user/withdraw/{code}")
    public ResponseEntity<String> deleteUser(@PathVariable String code) {
        try {
            userService.deleteUser(code);
            return ResponseEntity.status(200).body("탈퇴 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @ApiOperation(value = "로그인", notes = "구글 로그인 페이지로 이동")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 404, message = "nickname : 이름은 빈 값을 가질 수 없습니다.\nemail : 이메일은 빈 값을 가질 수 없습니다.")
    })
    @PostMapping("/user/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserSaveRequestDto requestDto) {
        userService.login(requestDto);

        return ResponseEntity.status(200).body("로그인 성공");
    }

}

