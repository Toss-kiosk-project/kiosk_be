package com.example.kiosk_be.domain.user.bean;

import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUserEntityBean {
    private final UserRepository userRepository;

    public List<UserEntity> exec() {
        return userRepository.findAll();
    }
}
