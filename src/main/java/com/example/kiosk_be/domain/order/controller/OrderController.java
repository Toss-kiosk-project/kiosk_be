package com.example.kiosk_be.domain.order.controller;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestGetOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestUpdateOrderStateDto;
import com.example.kiosk_be.domain.order.data.dto.ResponseGetOrderDto;
import com.example.kiosk_be.domain.order.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto) {
        UUID orderId = orderService.createOrder(requestCreateOrderDto);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("message", "주문 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/state")
    public ResponseEntity<Map<String, Object>> updateOrderState(@RequestBody RequestUpdateOrderStateDto requestUpdateOrderStateDto) {
        orderService.updateOrderState(requestUpdateOrderStateDto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "주문 상태 수정 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOrder(@RequestParam("orderId") UUID orderId) {
        OrderEntity orderEntity = orderService.getOrder(orderId);

        Map<String, Object> response = new HashMap<>();
        response.put("orderInfo", ResponseGetOrderDto.builder().orderEntity(orderEntity).build());
        response.put("message", "주문 단건 조회 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllOrder() {
        Map<String, Object> response = new HashMap<>();

        response.put("orderList",orderService.getAllOrders());
        response.put("message", "주문 전체 조회 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/code")
    public ResponseEntity<Map<String, Object>> getOrderCode(@RequestParam("orderId") UUID orderId) {
        Map<String, Object> response = new HashMap<>();

        response.put("orderCode", orderService.getOrderCode(orderId));
        response.put("message", "주문 코드 조회 완료!");
        response.put("isSuccess", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
