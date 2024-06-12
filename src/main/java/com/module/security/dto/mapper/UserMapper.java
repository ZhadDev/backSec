package com.module.security.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.module.security.dto.UserDto;
import com.module.security.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto modelToDto(User user);

    @InheritInverseConfiguration
    User dtoToModel(UserDto userDto);

    List<UserDto> modelToDtos(List<User> user);

}
