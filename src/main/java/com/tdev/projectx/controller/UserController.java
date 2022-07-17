package com.tdev.projectx.controller;

import com.tdev.projectx.model.User;
import com.tdev.projectx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService uService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(uService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable Long user_id) {
        return new ResponseEntity<>(uService.getUserByID(user_id), HttpStatus.FOUND);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(uService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable Long user_id,@Valid  @RequestBody User user) {
        user.setUser_id(user_id);
        return new ResponseEntity<>(uService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam Long user_id) {
        uService.deleteUser(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
