package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.config.auth.dto.SessionUser;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Api(tags = {"유저"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HttpSession httpSession;

    @ApiOperation(value = "홈 API")
    @GetMapping("/")
    public String hello() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if (sessionUser != null) {
            String userName = sessionUser.getName();
            return userName + "님 환영합니다.";
        } else {
            return "저기다에 오신 걸 환영합니다:)";
        }
    }

    @ApiOperation(value = "모든 유저 조회")
    @GetMapping("/user")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation(value = "마이페이지", notes = "로그인되어 있는 경우, 유저 정보 반환. 로그인되어 있지 않은 경우, 로그인이 필요하다는 안내 메세지 반환")
    @GetMapping("/user/mypage")
    public Object getUserInfo() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if (sessionUser != null) {
            return sessionUser;
        } else {
            return "로그인을 먼저 해주세요.";
        }
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

    @ApiOperation(value = "탈퇴하기")
    @ApiImplicitParam(name = "id", value = "유저 아이디(고유 식별 번호)", required = true)
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @ApiOperation(value = "로그인", notes = "구글 로그인 페이지로 이동")
    @GetMapping("/user/login")
    public void login(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/oauth2/authorization/google");
    }

    @ApiOperation(value = "로그아웃", notes = "세션 종료 후 홈 api로 이동")
    @GetMapping("/user/logout")
    public void logout(HttpServletResponse httpServletResponse) throws IOException {
        httpSession.invalidate();
        httpServletResponse.sendRedirect("/");
    }

    @ApiOperation(value = "로그인 유무", notes = "로그인 한 경우, true 반환 | 로그인 하지 않은 경우, false 반환")
    @GetMapping("/user/status")
    public Boolean getUserStatus() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if (sessionUser != null) {
            return true;
        } else {
            return false;
        }
    }
}

