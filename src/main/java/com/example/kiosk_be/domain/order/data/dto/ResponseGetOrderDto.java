package com.example.kiosk_be.domain.order.data.dto;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.State;
import jakarta.persistence.criteria.Order;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ResponseGetOrderDto {
    private UUID orderId;
    private State state;
    private int totalPrice;
    private int code;
    private LocalDateTime orderTime;
    private UUID userId;
    private int menuNum;

    @Builder
    public ResponseGetOrderDto(OrderEntity orderEntity) {
        orderId=orderEntity.getId();
        state=orderEntity.getState();
        totalPrice=orderEntity.getTotalPrice();
        code=orderEntity.getCode();
        orderTime=orderEntity.getOrderTime();
        userId=orderEntity.getUserId();
        menuNum=orderEntity.getMenuNum();
    }
}
