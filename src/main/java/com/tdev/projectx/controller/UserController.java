package com.tdev.projectx.controller;

import com.tdev.projectx.model.User;
import com.tdev.projectx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService uService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return uService.getUsers();
    }

    @GetMapping("/user/{userID}")
    public User getUser(@PathVariable Long userID) {
        return uService.getUserByID(userID);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return uService.addUser(user);
    }

    @PutMapping("/user/{userID}")
    public User updateUser(@PathVariable Long userID, @RequestBody User user) {
        // System.out.println("Updating the user data for the id: " + id);
        user.setUserID(userID);
        return uService.updateUser(user);
    }


    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userID) {
        uService.deleteUser(userID);
        return "This user with id: " + userID + " has been successfully deleted";
    }
}
