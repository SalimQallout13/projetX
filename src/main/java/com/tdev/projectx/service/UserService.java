package com.tdev.projectx.service;
import com.tdev.projectx.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserByID(Long userID);

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long userID);
}
