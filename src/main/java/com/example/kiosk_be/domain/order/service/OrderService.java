package com.example.kiosk_be.domain.order.service;

import com.example.kiosk_be.domain.order.bean.CreateOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.FindByIdOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.GetAllOrderEntityBean;
import com.example.kiosk_be.domain.order.bean.SaveOrderEntityBean;
import com.example.kiosk_be.domain.order.data.OrderEntity;
import com.example.kiosk_be.domain.order.data.dto.RequestCreateOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestGetOrderDto;
import com.example.kiosk_be.domain.order.data.dto.RequestUpdateOrderStateDto;
import com.example.kiosk_be.domain.order.data.dto.ResponseGetOrderDto;
import com.example.kiosk_be.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CreateOrderEntityBean createOrderEntityBean;
    private final SaveOrderEntityBean saveOrderEntityBean;
    private final FindByIdOrderEntityBean findByIdOrderEntityBean;
    private final GetAllOrderEntityBean getAllOrderEntityBean;

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

    public List<ResponseGetOrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = getAllOrderEntityBean.exec();
        List<ResponseGetOrderDto> responseGetOrderDtos = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
            responseGetOrderDtos.add(ResponseGetOrderDto.builder().orderEntity(orderEntity).build());
        }
        return responseGetOrderDtos;
    }

    public int getOrderCode(UUID orderId){
       OrderEntity orderEntity =  findByIdOrderEntityBean.exec(orderId);
       return orderEntity.getCode();
    }
}
