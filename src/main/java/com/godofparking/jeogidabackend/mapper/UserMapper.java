package com.godofparking.jeogidabackend.mapper;

import com.godofparking.jeogidabackend.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDto> getUserList();
    public UserDto getUser(Integer id);
    public int insertUser(UserDto userDto);
    public UserDto findByEmail(String email);
    public int updateUser(UserDto userDto);
    public int deleteUser(Integer id);
}