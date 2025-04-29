package com.example.kiosk_be.domain.order.service;

import com.example.kiosk_be.domain.order.bean.CreateOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.SaveOrderEntityBean;
import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CreateOrderEntityBean createOrderEntityBean;
    private final SaveOrderEntityBean saveOrderEntityBean;

    public void createOrder(RequestCreateOrderDto requestCreateOrderDto) {
        OrderEntity orderEntity = createOrderEntityBean.exec(requestCreateOrderDto);
        saveOrderEntityBean.exec(orderEntity);
    }
}
