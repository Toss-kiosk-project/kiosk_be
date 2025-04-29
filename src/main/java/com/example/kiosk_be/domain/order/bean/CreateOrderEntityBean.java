package com.example.kiosk_be.domain.order.bean;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.State;
import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import com.example.kiosk_be.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateOrderEntityBean {
    private final OrderRepository orderRepository;

    public OrderEntity exec(RequestCreateOrderDto requestCreateOrderDto) {
        return OrderEntity.builder()
                .id(UUID.randomUUID())
                .state(State.READY)
                .totalPrice(requestCreateOrderDto.getTotalPrice())
                .code(orderRepository.findMaxCode().orElse(0) + 1)
                .orderTime(LocalDateTime.now())
                .userId(requestCreateOrderDto.getUserId())
                .menuNum(requestCreateOrderDto.getMenuNum())
                .build();
    }
}
