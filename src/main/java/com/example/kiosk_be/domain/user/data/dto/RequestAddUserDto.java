package com.example.kiosk_be.domain.user.data.dto;

import com.example.kiosk_be.domain.user.data.Role;
import lombok.Getter;

@Getter
public class RequestAddUserDto {
    private String email;
    private Role role;
    private String password;
    private String userName;
}
