package com.example.kiosk_be.domain.menu.bean;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import com.example.kiosk_be.domain.menu.data.dto.RequestUpdateMenuDto;
import com.example.kiosk_be.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateMenuEntityBean {
    public MenuEntity exec(RequestUpdateMenuDto requestUpdateMenuDto){
        return MenuEntity.builder()
                .id(requestUpdateMenuDto.getMenuId())
                .name(requestUpdateMenuDto.getName())
                .category(requestUpdateMenuDto.getCategory())
                .price(requestUpdateMenuDto.getPrice())
                .img(requestUpdateMenuDto.getImg())
                .hasDelete(false)
                .build();
    }
}
