package com.module.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.security.dto.UserDto;
import com.module.security.dto.mapper.UserMapper;
import com.module.security.entities.User;
import com.module.security.errors.UserNotFoundException;
import com.module.security.repository.UserRepository;
import com.module.security.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> sec_r_user() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = (List<User>) userRepository.findAll();
        userDtos = userMapper.modelToDtos(users);

        return userDtos;
    }

    @Override
    public UserDto sec_cu_user(UserDto userDto) {
        if (userDto.getId() == 0) { // create
            User user = new User();
            user = userMapper.dtoToModel(userDto);
            user = userRepository.save(user);
            userDto = userMapper.modelToDto(user);
        } else {

            User user = userRepository.findById(userDto.getId()).get();
            user = userMapper.dtoToModel(userDto);
            user = userRepository.save(user);
            userDto = userMapper.modelToDto(user);
        }

        return userDto;
    }

    @Override
    public void sec_d_user(Integer Id) throws UserNotFoundException {
        if (userRepository.findById(Id).isPresent()) {
            userRepository.deleteById(Id);
        } else {
            throw new UserNotFoundException("User is not available");
        }

    }

    @Override
    public UserDto sec_filter_user(Integer Id) throws UserNotFoundException {
        UserDto userDto = new UserDto();
        if (userRepository.findById(Id).isPresent()) {
            userDto = userMapper.modelToDto(userRepository.findById(Id).get());
        } else {
            throw new UserNotFoundException("User is not available");
        }
        return userDto;
    }

}
