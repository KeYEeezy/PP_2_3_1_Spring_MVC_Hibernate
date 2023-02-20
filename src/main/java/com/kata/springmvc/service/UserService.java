package com.kata.springmvc.service;

import com.kata.springmvc.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> findAll();

    User findUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
