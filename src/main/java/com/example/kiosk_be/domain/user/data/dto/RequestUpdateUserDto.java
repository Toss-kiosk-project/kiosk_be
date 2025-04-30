package com.example.kiosk_be.domain.user.data.dto;

import com.example.kiosk_be.domain.user.data.Role;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RequestUpdateUserDto {
    private UUID userId;
    private String userName;
    private Role role;
}
