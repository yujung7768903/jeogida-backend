package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    // 모든 유저 조회
    @GetMapping("/user")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    // 아이디로 특정 유저 정보 조회
    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    // 이메일로 특정 유저 아이디 조회
    @GetMapping("/user/id/{email}")
    public Integer getIdByEmail(@PathVariable String email) {
        return userService.findByEmail(email).getId();
    }

    // 유저 등록
    @PostMapping("/user")
    public boolean save(@RequestBody UserDto userDto) {
        return userService.insertUser(userDto);
    }

    // 유저 정보 수정
    @PatchMapping("/user/{id}")
    public boolean updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    // 유저 삭제
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/user/login")
    public String login(Model model) {
        return "login";
    }
}

