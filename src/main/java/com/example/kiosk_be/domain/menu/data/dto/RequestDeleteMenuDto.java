package com.example.kiosk_be.domain.menu.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDeleteMenuDto {
    private UUID menuId;
}
