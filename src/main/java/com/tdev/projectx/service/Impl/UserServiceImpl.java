package com.tdev.projectx.service.Impl;

import com.tdev.projectx.model.User;
import com.tdev.projectx.repo.UserRepository;
import com.tdev.projectx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Long userID) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("User not found for this id: " + userID);
    }

    @Override
    public User addUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("This email is taken");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }

}
