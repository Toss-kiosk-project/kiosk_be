package com.example.kiosk_be.domain.user.bean;

import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetUserEntityBean {
    private final UserRepository userRepository;

    public UserEntity exec(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
