package com.tdev.projectx.service.Impl;

import com.tdev.projectx.model.Menu;
import com.tdev.projectx.repo.ClubRepository;
import com.tdev.projectx.repo.MenuRepository;
import com.tdev.projectx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ClubRepository clubRepository;

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
        System.out.println(menu.getClub());
        return menu;
       // return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        boolean exists = menuRepository.existsById(menu.getMenu_id());
        if (!exists) {
            throw new IllegalStateException("The menu with id " + menu.getMenu_id() + " does not exists");
        }
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long menuID) {
        boolean exists = menuRepository.existsById(menuID);
        if (!exists) {
            throw new IllegalStateException("The menu with id " + menuID + " does not exists");
        }
        menuRepository.deleteById(menuID);
    }

}
