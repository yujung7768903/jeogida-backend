package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.dto.UserSaveRequestDto;
import com.godofparking.jeogidabackend.dto.UserUpdateRequestDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUserList();
    public UserDto getUser(String code);
    public void insertUser(UserSaveRequestDto requestDto);
    public UserDto findByEmail(String email);

    public UserDto findByCode(String code);
    public boolean updateUser(String code, UserUpdateRequestDto requestDto);
    public boolean deleteUser(String code);
    public void login(UserSaveRequestDto requestDto);
}