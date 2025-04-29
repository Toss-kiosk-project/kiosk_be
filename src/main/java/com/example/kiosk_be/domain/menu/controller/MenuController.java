package com.example.kiosk_be.domain.menu.controller;

import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import com.example.kiosk_be.domain.menu.data.dto.RequestUpdateMenuDto;
import com.example.kiosk_be.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
// 공통된 /api/menu를 사용하기 때문에 붙여줌
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMenu(@RequestBody RequestCreateMenuDto requestCreateMenuDto) {
        UUID menuId = menuService.createMenu(requestCreateMenuDto);

        Map<String, Object> response = new HashMap<>();
        response.put("menuId", menuId);
        response.put("message", "메뉴 추가 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateMenu(@RequestBody RequestUpdateMenuDto requestUpdateMenuDto) {
        UUID menuId = menuService.updateMenu(requestUpdateMenuDto);

        Map<String, Object> response = new HashMap<>();
        response.put("menuId", menuId);
        response.put("message", "메뉴 수정 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
