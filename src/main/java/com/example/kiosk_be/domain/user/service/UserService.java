package com.example.kiosk_be.domain.user.service;

import com.example.kiosk_be.domain.user.bean.AddUserEntityBean;
import com.example.kiosk_be.domain.user.bean.GetAllUserEntityBean;
import com.example.kiosk_be.domain.user.bean.GetUserEntityBean;
import com.example.kiosk_be.domain.user.bean.SaveUserEntityBean;
import com.example.kiosk_be.domain.user.data.Role;
import com.example.kiosk_be.domain.user.data.UserEntity;
import com.example.kiosk_be.domain.user.data.dto.RequestAddUserDto;
import com.example.kiosk_be.domain.user.data.dto.RequestLoginDto;
import com.example.kiosk_be.domain.user.data.dto.ResponseGetUserDto;
import com.example.kiosk_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final GetUserEntityBean getUserEntityBean;
    private final SaveUserEntityBean saveUserEntityBean;
    private final AddUserEntityBean addUserEntityBean;
    private final GetAllUserEntityBean getAllUserEntityBean;

    public ResponseGetUserDto getUser(UUID userId) {
        UserEntity userEntity = getUserEntityBean.exec(userId);
        saveUserEntityBean.exec(userEntity);

        return ResponseGetUserDto.builder().userEntity(userEntity).build();
    }

    public ResponseGetUserDto login(RequestLoginDto requestLoginDto) {
        UserEntity userEntity = getUserEntityBean.exec(requestLoginDto.getEmail());
        if (userEntity.getPassword().equals(requestLoginDto.getPassword())) {
            return ResponseGetUserDto.builder().userEntity(userEntity).build();
        } else {
            return null;
        }
    }

    public ResponseGetUserDto addUser(RequestAddUserDto requestAddUserDto) {
        UserEntity userEntity = addUserEntityBean.exec(requestAddUserDto);
        saveUserEntityBean.exec(userEntity);

        return ResponseGetUserDto.builder().userEntity(userEntity).build();
    }

    public List<ResponseGetUserDto> getAllUsers() {
        List<UserEntity> userList = getAllUserEntityBean.exec();
        List<ResponseGetUserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : userList) {
            if(!userEntity.isHasDelete()) userDtoList.add(ResponseGetUserDto.builder().userEntity(userEntity).build());
        }

        return userDtoList;
    }
}
