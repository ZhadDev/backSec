package com.module.security.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.module.security.dto.ResponseApiDto;
import com.module.security.dto.UserDto;
import com.module.security.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserController {
    private ResponseApiDto responseApiDto;

    public UserController() {
        responseApiDto = new ResponseApiDto();
        responseApiDto.setCodeName("PENDING");
    }

    @Autowired
    IUserService userService;

    @GetMapping(path = "prueba")
    public String prueba() {
        return "Prueba";
    }

    @PostMapping(path = "saveUser")
    public ResponseEntity<ResponseApiDto> saveUpdateUser(@RequestBody UserDto userDto) {
        responseApiDto.setCodeResponse(HttpStatus.CREATED.value());
        responseApiDto.setCodeName(HttpStatus.CREATED.series().name());
        responseApiDto.setData(userService.sec_cu_user(userDto));

        return new ResponseEntity<ResponseApiDto>(responseApiDto, HttpStatus.OK);
    }

    @GetMapping(path = "allUser")
    public ResponseEntity<ResponseApiDto> allUser() {
        responseApiDto.setCodeResponse(HttpStatus.OK.value());
        responseApiDto.setCodeName(HttpStatus.CREATED.series().name());
        responseApiDto.setData(userService.sec_r_user());

        return new ResponseEntity<ResponseApiDto>(responseApiDto, HttpStatus.OK);
    }

}
