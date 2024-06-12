package com.module.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.security.dto.UserDto;
import com.module.security.dto.mapper.UserMapper;
import com.module.security.entities.User;
import com.module.security.repository.UserRepository;
import com.module.security.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto sec_cu_user(UserDto userDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sec_cu_user'");
    }

    @Override
    public List<UserDto> sec_r_user() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = (List<User>) userRepository.findAll();
        userDtos = userMapper.modelToDtos(users);

        return userDtos;
    }

    @Override
    public void sec_d_user(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sec_d_user'");
    }

    @Override
    public UserDto sec_filter_user(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sec_filter_user'");
    }

}
