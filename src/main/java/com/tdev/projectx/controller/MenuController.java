package com.tdev.projectx.controller;

import com.tdev.projectx.model.Menu;
import com.tdev.projectx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService uService;

    @GetMapping("/menu/{menuID}")
    public Menu getMenu(@PathVariable Long menuID) {
        return uService.getMenuByID(menuID);
    }

    @PostMapping("/menu")
    public Menu addMenu(@RequestBody Menu menu) {
        return uService.addMenu(menu);
    }

    @PutMapping("/menu/{menuID}")
    public Menu updateMenu(@PathVariable Long menuID, @RequestBody Menu menu) {
        // System.out.println("Updating the menu data for the id: " + id);
        menu.setMenu_id(menuID);
        return uService.updateMenu(menu);
    }


    @DeleteMapping("/menu")
    public String deleteMenu(@RequestParam Long menuID) {
        uService.deleteMenu(menuID);
        return "This menu with id: " + menuID + " has been successfully deleted";
    }
}
