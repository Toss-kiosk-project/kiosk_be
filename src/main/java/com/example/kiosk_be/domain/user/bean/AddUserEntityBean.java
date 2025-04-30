package com.example.kiosk_be.domain.user.bean;

import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.data.dto.RequestAddUserDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddUserEntityBean {
    public UserEntity exec(RequestAddUserDto requestAddUserDto) {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .email(requestAddUserDto.getEmail())
                .role(requestAddUserDto.getRole())
                .password(requestAddUserDto.getPassword())
                .userName(requestAddUserDto.getUserName())
                .hasDelete(false)
                .build();
    }
}
