package com.example.kiosk_be.domain.menu.bean;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMenuEntityBean {
    private final MenuRepository menuRepository;

    // DB 저장
    public void exec(MenuEntity menuEntity){
        menuRepository.save(menuEntity);
    }
}
