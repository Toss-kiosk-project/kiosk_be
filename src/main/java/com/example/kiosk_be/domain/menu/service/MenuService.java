package com.example.kiosk_be.domain.menu.service;

import com.example.kiosk_be.domain.menu.bean.*;
import com.example.kiosk_be.domain.menu.data.MenuEntity;
import com.example.kiosk_be.domain.menu.data.dto.RequestCreateMenuDto;
import com.example.kiosk_be.domain.menu.data.dto.RequestUpdateMenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
//final 붙은 변수를 찾아서 자동으로 생성자를 만들어줌
@RequiredArgsConstructor
public class MenuService {
    private final CreateMenuEntityBean createMenuEntityBean;
    private final SaveMenuEntityBean saveMenuEntityBean;
    private final UpdateMenuEntityBean updateMenuEntityBean;
    private final FindByIdMenuEntityBean findByIdMenuEntityBean;
    private final FindAllMenuEntityBean findAllMenuEntityBean;

    public UUID createMenu(RequestCreateMenuDto requestCreateMenuDto){
        MenuEntity menuEntity = createMenuEntityBean.exec(requestCreateMenuDto);
        saveMenuEntityBean.exec(menuEntity);
        return menuEntity.getId();
    }

    public UUID updateMenu(RequestUpdateMenuDto requestUpdateMenuDto){
        MenuEntity menuEntity = updateMenuEntityBean.exec(requestUpdateMenuDto);
        saveMenuEntityBean.exec(menuEntity);
        return menuEntity.getId();

    }

    public RequestUpdateMenuDto findById(UUID id){
       MenuEntity menuEntity= findByIdMenuEntityBean.exec(id);
        return RequestUpdateMenuDto.builder().menuEntity(menuEntity).build();
    }

    public List<RequestUpdateMenuDto> findAll(){
        List<MenuEntity> menuEntities = findAllMenuEntityBean.exec();
        List<RequestUpdateMenuDto> menuDtos = new ArrayList<>();
        for(MenuEntity menuEntity: menuEntities){
            menuDtos.add(RequestUpdateMenuDto.builder().menuEntity(menuEntity).build());
        }
        return menuDtos;
    }
}
