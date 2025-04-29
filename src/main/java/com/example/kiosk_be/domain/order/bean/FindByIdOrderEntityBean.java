package com.example.kiosk_be.domain.order.bean;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindByIdOrderEntityBean {
    private final OrderRepository orderRepository;

    public OrderEntity exec(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }
}
