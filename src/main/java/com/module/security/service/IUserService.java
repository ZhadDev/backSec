package com.module.security.service;

import java.util.List;

import com.module.security.dto.UserDto;
import com.module.security.errors.UserNotFoundException;

public interface IUserService {
    UserDto sec_cu_user(UserDto userDto);

    List<UserDto> sec_r_user();

    void sec_d_user(Integer Id) throws UserNotFoundException;;

    UserDto sec_filter_user(Integer Id) throws UserNotFoundException;

}
