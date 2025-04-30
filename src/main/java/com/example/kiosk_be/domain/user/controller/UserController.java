package com.example.kiosk_be.domain.user.controller;

import com.example.kiosk_be.domain.user.data.dto.*;
import com.example.kiosk_be.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam("userId") UUID userId) {
        ResponseGetUserDto userInfo = userService.getUser(userId);

        Map<String, Object> response = new HashMap<>();
        response.put("userInfo", userInfo);
        response.put("message", "유저 조회 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestLoginDto requestLoginDto) {
        ResponseGetUserDto userInfo = userService.login(requestLoginDto);

        Map<String, Object> response = new HashMap<>();
        response.put("userInfo", userInfo);
        response.put("message", "로그인 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody RequestAddUserDto requestAddUserDto) {
        ResponseGetUserDto userInfo = userService.addUser(requestAddUserDto);

        Map<String, Object> response = new HashMap<>();
        response.put("userInfo", userInfo);
        response.put("message", "유저 추가 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllUser() {
        List<ResponseGetUserDto> userInfoList = userService.getAllUsers();

        Map<String, Object> response = new HashMap<>();
        response.put("userList", userInfoList);
        response.put("message", "유저 조회 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUpdateUserDto requestUpdateUserDto) {
        ResponseGetUserDto userInfo = userService.updateUser(requestUpdateUserDto);

        Map<String, Object> response = new HashMap<>();
        response.put("userInfo", userInfo);
        response.put("message", "유저 수정 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody RequestDeleteUserDto requestDeleteUserDto) {
        userService.deleteUser(requestDeleteUserDto.getUserId());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "유저 삭제 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
