package com.example.kiosk_be.domain.order.service;

import com.example.kiosk_be.domain.order.bean.CreateOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.FindByIdOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.SaveOrderEntityBean;
import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestGetOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestUpdateOrderStateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CreateOrderEntityBean createOrderEntityBean;
    private final SaveOrderEntityBean saveOrderEntityBean;
    private final FindByIdOrderEntityBean findByIdOrderEntityBean;

    public UUID createOrder(RequestCreateOrderDto requestCreateOrderDto) {
        OrderEntity orderEntity = createOrderEntityBean.exec(requestCreateOrderDto);
        saveOrderEntityBean.exec(orderEntity);
        return orderEntity.getId();
    }

    public void updateOrderState(RequestUpdateOrderStateDto requestUpdateOrderStateDto) {
        OrderEntity orderEntity = findByIdOrderEntityBean.exec(requestUpdateOrderStateDto.getOrderId());
        orderEntity.updateState(requestUpdateOrderStateDto.getState());
        saveOrderEntityBean.exec(orderEntity);
    }

    public OrderEntity getOrder(UUID orderId) {
        return findByIdOrderEntityBean.exec(orderId);
    }
}
