package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"유저"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "홈 API")
    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @ApiOperation(value = "모든 유저 조회")
    @GetMapping("/user")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation(value = "아이디로 특정 유저 정보 조회")
    @ApiImplicitParam(name = "id", value = "유저 아이디(고유 식별 번호)", required = true)
    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @ApiOperation(value = "이메일로 특정 유저 정보 조회")
    @ApiImplicitParam(name = "email", value = "유저 이메일", required = true)
    @GetMapping("/user/id/{email}")
    public Integer getIdByEmail(@PathVariable String email) {
        return userService.findByEmail(email).getId();
    }

    @ApiOperation(value = "유저 등록")
    @PostMapping("/user")
    public boolean save(@RequestBody UserDto userDto) {
        return userService.insertUser(userDto);
    }

    @ApiOperation(value = "유저 정보 수정")
    @ApiImplicitParam(name = "id", value = "유저 아이디(고유 식별 번호)", required = true)
    @PatchMapping("/user/{id}")
    public boolean updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @ApiOperation(value = "유저 삭제")
    @ApiImplicitParam(name = "id", value = "유저 아이디(고유 식별 번호)", required = true)
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/user/login")
    public String login(Model model) {
        return "login";
    }
}

