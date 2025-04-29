package com.example.kiosk_be.domain.menu.bean;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllMenuEntityBean {
    private final MenuRepository menuRepository;

    public List<MenuEntity> exec(){
        return menuRepository.findAll();
    }
}
