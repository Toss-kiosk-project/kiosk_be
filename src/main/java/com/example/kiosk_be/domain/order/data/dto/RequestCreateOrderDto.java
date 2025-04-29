package com.example.kiosk_be.domain.order.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateOrderDto {
    private UUID userId;
    private int totalPrice;
    private int menuNum;
}
