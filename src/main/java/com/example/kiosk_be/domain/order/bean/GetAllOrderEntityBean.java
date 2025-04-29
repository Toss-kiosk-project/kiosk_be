package com.example.kiosk_be.domain.order.bean;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrderEntityBean {
    private final OrderRepository orderRepository;

    public List<OrderEntity> exec(){
        return orderRepository.findAll();
    }
}
