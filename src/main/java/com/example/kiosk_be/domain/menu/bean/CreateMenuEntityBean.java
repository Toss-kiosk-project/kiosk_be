package com.example.kiosk_be.domain.menu.bean;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateMenuEntityBean {
    public MenuEntity exec(RequestCreateMenuDto requestCreateMenuDto) {
        return MenuEntity.builder()
                .id(UUID.randomUUID())
                .name(requestCreateMenuDto.getName())
                .category(requestCreateMenuDto.getCategory())
                .price(requestCreateMenuDto.getPrice())
                .img(requestCreateMenuDto.getImg())
                .hasDelete(false)
                .build();
    }
}
