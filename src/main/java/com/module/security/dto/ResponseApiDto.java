package com.module.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseApiDto {
    private int codeResponse;
    private String codeName;
    private Object data;

}
