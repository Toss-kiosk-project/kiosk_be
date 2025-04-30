package com.example.kiosk_be.domain.user.controller;

import com.example.kiosk_be.domain.user.data.dto.ResponseGetUserDto;
import com.example.kiosk_be.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
}
