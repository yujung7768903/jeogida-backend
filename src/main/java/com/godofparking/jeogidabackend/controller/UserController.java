package com.godofparking.jeogidabackend.controller;

import com.godofparking.jeogidabackend.config.auth.LoginUser;
import com.godofparking.jeogidabackend.config.auth.dto.SessionUser;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@Api(tags = {"유저"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HttpSession httpSession;

    @ApiOperation(value = "홈 API")
    @GetMapping("/")
    public String hello(@LoginUser SessionUser user) {
        if (user != null) {
            String userName = user.getNickname();
            return userName + "님 환영합니다.";
        } else {
            return "저기다에 오신 걸 환영합니다:)";
        }
    }

    @ApiOperation(value = "모든 유저 조회")
    @GetMapping("/user/all")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation(value = "마이페이지", notes = "로그인되어 있는 경우, 유저 정보 반환. 로그인되어 있지 않은 경우, 로그인이 필요하다는 안내 메세지 반환")
    @GetMapping("/user/mypage")
    public Object getUserInfo(@LoginUser SessionUser user) {
        if (user != null) {
            return user;
        } else {
            return "로그인을 먼저 해주세요.";
        }
    }

    @ApiOperation(value = "아이디로 특정 유저 정보 조회")
    @GetMapping("/user")
    public UserDto getUser(@LoginUser SessionUser user) {
        return userService.getUser(user.getId());
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
    @PatchMapping("/user")
    public boolean updateUser(@LoginUser SessionUser user, @RequestBody UserDto userDto) {
        return userService.updateUser(user.getId(), userDto);
    }

    @ApiOperation(value = "탈퇴하기")
    @DeleteMapping("/user/withdraw")
    public boolean deleteUser(@LoginUser SessionUser user) {
        return userService.deleteUser(user.getId());
    }

    @ApiOperation(value = "로그인", notes = "구글 로그인 페이지로 이동")
    @GetMapping("/user/login")
    public boolean login(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("/oauth2/authorization/google");
            return true;
        } catch (IOException e) {
            log.error("요청을 처리하는 과정에서 오류가 발생했습니다: {}", e);
            return false;
        }
    }

    @ApiOperation(value = "로그아웃", notes = "세션 종료 후 홈 api로 이동")
    @GetMapping("/user/logout")
    public boolean logout(HttpServletResponse httpServletResponse) {
        try {
            httpSession.invalidate();
            httpServletResponse.sendRedirect("/");
            return true;
        } catch (IOException e) {
            log.error("요청을 처리하는 과정에서 오류가 발생했습니다: {}", e);
            return false;
        }
    }

    @ApiOperation(value = "로그인 유무", notes = "로그인 한 경우, true 반환 | 로그인 하지 않은 경우, false 반환")
    @GetMapping("/user/status")
    public boolean getUserStatus(@LoginUser SessionUser user) {
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}

