package com.tdev.projectx.controller;

import com.tdev.projectx.model.Menu;
import com.tdev.projectx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService uService;

    @GetMapping("/menu/{menuID}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long menuID) {
        return new ResponseEntity<Menu>(uService.getMenuByID(menuID), HttpStatus.FOUND);
    }

    @PostMapping("/menu")
    public ResponseEntity<Menu> addMenu(@Valid @RequestBody Menu menu) {
        return new ResponseEntity<Menu>(uService.addMenu(menu), HttpStatus.CREATED);
    }

    @PutMapping("/menu/{menuID}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long menuID,@Valid @RequestBody Menu menu) {
        // System.out.println("Updating the menu data for the id: " + id);
        menu.setMenu_id(menuID);
        return new ResponseEntity<Menu>(uService.updateMenu(menu), HttpStatus.OK);
    }


    @DeleteMapping("/menu")
    public ResponseEntity<HttpStatus> deleteMenu(@RequestParam Long menuID) {
        uService.deleteMenu(menuID);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
