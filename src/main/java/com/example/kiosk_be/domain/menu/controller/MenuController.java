package com.example.kiosk_be.domain.menu.controller;

import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import com.example.kiosk_be.domain.menu.data.dto.RequestDeleteMenuDto;
import com.example.kiosk_be.domain.menu.data.dto.RequestUpdateMenuDto;
import com.example.kiosk_be.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping
    public ResponseEntity<Map<String, Object>> getMenu(@RequestParam("menuId") UUID menuId){
        Map<String, Object> response = new HashMap<>();

        RequestUpdateMenuDto requestUpdateMenuDto= menuService.findById(menuId);
        response.put("menuInfo",requestUpdateMenuDto);
        response.put("message", "메뉴 조회 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllMenu(){
        Map<String,Object> response = new HashMap<>();

        List<RequestUpdateMenuDto> requestUpdateMenuDtoList = menuService.findAll();
        response.put("menuInfo",requestUpdateMenuDtoList);
        response.put("message", "메뉴 전체 조회 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteMenu(@RequestBody RequestDeleteMenuDto requestDeleteMenuDto) {
        Map<String,Object> response = new HashMap<>();

        menuService.deleteMenu(requestDeleteMenuDto.getMenuId());
        response.put("message", "메뉴 삭제 성공!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
