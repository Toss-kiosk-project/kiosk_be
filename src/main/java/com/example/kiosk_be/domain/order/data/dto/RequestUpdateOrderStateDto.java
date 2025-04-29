package com.example.kiosk_be.domain.order.data.dto;

import com.example.kiosk_be.domain.order.data.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateOrderStateDto {
    private UUID orderId;
    private State state;
}
