package com.example.kiosk_be.domain.user.service;

import com.example.kiosk_be.domain.user.bean.GetUserEntityBean;
import com.example.kiosk_be.domain.user.bean.SaveUserEntityBean;
import com.example.kiosk_be.domain.user.data.Role;
import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.data.dto.ResponseGetUserDto;
import com.example.kiosk_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final GetUserEntityBean getUserEntityBean;
    private final SaveUserEntityBean saveUserEntityBean;

    public ResponseGetUserDto getUser(UUID userId) {
        UserEntity userEntity = getUserEntityBean.exec(userId);
        saveUserEntityBean.exec(userEntity);

        return ResponseGetUserDto.builder().userEntity(userEntity).build();
    }

    public ResponseGetUserDto login(String email, String password) {
        UserEntity userEntity = getUserEntityBean.exec(email);
        if (userEntity.getPassword().equals(password)) {
            return ResponseGetUserDto.builder().userEntity(userEntity).build();
        } else {
            return null;
        }
    }
}
