package com.godofparking.jeogidabackend.service;


import com.godofparking.jeogidabackend.dto.Role;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.dto.UserSaveRequestDto;
import com.godofparking.jeogidabackend.dto.UserUpdateRequestDto;
import com.godofparking.jeogidabackend.exception.DuplicateException;
import com.godofparking.jeogidabackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImplement implements UserService{
    private final UserMapper userMapper;

    // 모든 유저 조회
    @Override
    public List<UserDto> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public UserDto getUser(String code) {
        UserDto userDto = checkUserByCode(code);

        return userDto;
    }

    // 이메일로 유저 찾기
    @Override
    public UserDto findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public UserDto findByCode(String code) {
        return userMapper.findByCode(code);
    }

    // 유저 등록
    @Override
    public void insertUser(UserSaveRequestDto requestDto) {
        UserDto userDto = userMapper.findByCode(requestDto.getCode());

        if (userDto != null) {
            throw new DuplicateException("해당 코드를 가진 유저가 이미 존재합니다.");
        } else {
            userMapper.insertUser(requestDto.toUser());
        }
    }

    // 유저 정보 수정
    @Override
    public boolean updateUser(String code, UserUpdateRequestDto requestDto) {
        UserDto userDto = checkUserByCode(code);

        try {
            userDto.update(requestDto.getEmail(), requestDto.getNickname(), requestDto.getPhoto_url());
            userMapper.updateUser(userDto);
            return true;
        }catch (Exception e) {
            log.error("error: {}", e.getMessage());
            return false;
        }
    }

    // 유저 삭제
    @Override
    public boolean deleteUser(String code) {
        UserDto userDto = checkUserByCode(code);

        try {
            userMapper.deleteUser(code);
            return true;
        }catch (Exception e) {
            log.error("error: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public void login(UserSaveRequestDto requestDto) {
        UserDto userDto = userMapper.findByCode(requestDto.getCode());

        if (userDto != null) { // 중복된 코드 존재 -> 유저 정보 업데이트
            userDto = userDto.update(requestDto.getEmail(), requestDto.getNickname(), Role.USER, requestDto.getPhoto_url());
            userMapper.updateUser(userDto);
        } else {
            userMapper.insertUser(requestDto.toUser());
        }
    }

    public UserDto checkUserByCode(String code) {
        UserDto userDto = userMapper.getUser(code);

        if (userDto == null) {
            throw new IllegalArgumentException("해당 코드를 가진 유저는 존재하지 않습니다.");
        }

        return userDto;
    }

}
