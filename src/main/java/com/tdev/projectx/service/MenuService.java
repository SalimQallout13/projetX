package com.tdev.projectx.service;

import com.tdev.projectx.model.Menu;

import java.util.List;

public interface MenuService {

    Menu getMenuByID(Long menuID);

    Menu addMenu(Menu menu);

    Menu updateMenu(Menu menu);

    void deleteMenu(Long menuID);
}
