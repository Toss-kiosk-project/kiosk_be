package com.example.kiosk_be.domain.menu.service;

import com.example.kiosk_be.domain.menu.bean.CreateMenuEntityBean;
import com.example.kiosk_be.domain.menu.bean.SaveMenuEntityBean;
import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//final 붙은 변수를 찾아서 자동으로 생성자를 만들어줌
@RequiredArgsConstructor
public class MenuService {
    private final CreateMenuEntityBean createMenuEntityBean;
    private final SaveMenuEntityBean saveMenuEntityBean;

    public UUID createMenu(RequestCreateMenuDto requestCreateMenuDto){
        MenuEntity menuEntity = createMenuEntityBean.exec(requestCreateMenuDto);
        saveMenuEntityBean.exec(menuEntity);
        return menuEntity.getId();
    }
}
