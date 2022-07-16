package com.tdev.projectx.service.Impl;

import com.tdev.projectx.model.Menu;
import com.tdev.projectx.repo.MenuRepository;
import com.tdev.projectx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu getMenuByID(Long menuID) {
        Optional<Menu> menu = menuRepository.findById(menuID);
        if (menu.isPresent()) {
            return menu.get();
        }
        throw new RuntimeException("Menu not found for this id: " + menuID);
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long menuID) {
        menuRepository.deleteById(menuID);
    }

}
