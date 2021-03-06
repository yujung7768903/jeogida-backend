package com.godofparking.jeogidabackend.service;

import com.godofparking.jeogidabackend.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUserList();
    public UserDto getUser(Integer id);
    public boolean insertUser(UserDto userDto);
    public UserDto findByEmail(String email);
    public boolean updateUser(Integer id, UserDto userDto);
    public boolean deleteUser(Integer id);
}