package com.example.kiosk_be.domain.menu.data.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateMenuDto {
    private String name;
    private String category;
    private int price;
    private String img;
}
