package com.godofparking.jeogidabackend.service;


import com.godofparking.jeogidabackend.dto.Role;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserDto getUser(Integer id) {
        return userMapper.getUser(id);
    }

    // 이메일로 유저 찾기
    @Override
    public UserDto findByEmail(String email) {
        UserDto userDto = userMapper.findByEmail(email);
        return userDto;
    }

    // 유저 등록
    @Override
    public boolean insertUser(UserDto userDto) {
        if (userDto.getRole() == null) {
            userDto.setRole(Role.GUEST);
        }
        try {
            userMapper.insertUser(userDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 유저 정보 수정
    @Override
    public boolean updateUser(Integer id, UserDto userDto) {
        userDto.setId(id);
        try {
            userMapper.updateUser(userDto);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }

    // 유저 삭제
    @Override
    public boolean deleteUser(Integer id) {
        try {
            userMapper.deleteUser(id);
            return true;
        }catch (Exception e) {
            System.out.println("error: " + e);
            return false;
        }
    }


}
