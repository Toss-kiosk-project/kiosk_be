package com.example.kiosk_be.domain.menu.bean;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindByIdMenuEntityBean {
    private final MenuRepository menuRepository;

    public MenuEntity exec(UUID menuId){
        return menuRepository.findById(menuId).orElse(null);
    }
}
