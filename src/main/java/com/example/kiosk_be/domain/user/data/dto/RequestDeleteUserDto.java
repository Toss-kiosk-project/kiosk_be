package com.example.kiosk_be.domain.user.data.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class RequestDeleteUserDto {
    private UUID userId;
}
