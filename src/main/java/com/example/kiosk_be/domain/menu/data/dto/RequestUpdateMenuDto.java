package com.example.kiosk_be.domain.menu.data.dto;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateMenuDto {
    private UUID menuId;
    private String name;
    private String category;
    private int  price;
    private String img;

    @Builder
    public RequestUpdateMenuDto(MenuEntity menuEntity) {
        menuId = menuEntity.getId();
        name = menuEntity.getName();
        category = menuEntity.getCategory();
        price = menuEntity.getPrice();
        img = menuEntity.getImg();
    }
}
