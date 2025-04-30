package com.example.kiosk_be.domain.user.bean;

import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.data.dto.RequestUpdateUserDto;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserEntityBean {
    public UserEntity exec(RequestUpdateUserDto requestUpdateUserDto, UserEntity userEntity) {
        return UserEntity.builder()
                .id(requestUpdateUserDto.getUserId())
                .userName(requestUpdateUserDto.getUserName())
                .role(requestUpdateUserDto.getRole())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .hasDelete(false)
                .build();
    }
}
