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
        return new ResponseEntity<List<User>>(uService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<User> getUser(@PathVariable Long userID) {
        return new ResponseEntity<User>(uService.getUserByID(userID), HttpStatus.FOUND);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(uService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/user/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable Long userID,@Valid  @RequestBody User user) {
        user.setUser_id(userID);
        return new ResponseEntity<User>(uService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam Long userID) {
        uService.deleteUser(userID);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
