package com.example.kiosk_be.domain.order.bean;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOrderEntityBean {
    private final OrderRepository orderRepository;

    public void exec(OrderEntity orderEntity){orderRepository.save(orderEntity);}
}
