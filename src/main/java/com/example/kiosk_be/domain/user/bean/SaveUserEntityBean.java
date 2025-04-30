package com.example.kiosk_be.domain.user.bean;

import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserEntityBean {
    private final UserRepository userRepository;

    public void exec(UserEntity userEntity) {userRepository.save(userEntity);}
}
