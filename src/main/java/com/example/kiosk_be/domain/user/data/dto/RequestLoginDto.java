package com.example.kiosk_be.domain.user.data.dto;

import lombok.Getter;

@Getter
public class RequestLoginDto {
    private String email;
    private String password;
}
