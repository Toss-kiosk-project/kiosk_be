package com.example.kiosk_be.domain.order.controller;

import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import com.example.kiosk_be.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto) {
        orderService.createOrder(requestCreateOrderDto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "주문 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
