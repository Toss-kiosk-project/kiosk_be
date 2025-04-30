package com.example.kiosk_be.domain.user.data.dto;

import com.example.kiosk_be.domain.user.data.Role;
import com.example.kiosk_be.domain.user.data.UserEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ResponseGetUserDto {
    private UUID userId;
    private String userName;
    private String email;
    private Role role;

    @Builder
    public ResponseGetUserDto(UserEntity userEntity) {
        userId=userEntity.getId();
        userName = userEntity.getUserName();
        email = userEntity.getEmail();
        role = userEntity.getRole();
    }
}
