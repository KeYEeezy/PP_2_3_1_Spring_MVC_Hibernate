package com.kata.springmvc.dao;

import com.kata.springmvc.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    List<User> allUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);
}
