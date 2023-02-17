package com.kata.springmvc.service;

import com.kata.springmvc.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> allUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);
}
