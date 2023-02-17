package com.kata.springmvc.service;

import com.kata.springmvc.dao.UserDAO;
import com.kata.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void editUser(Long id, User user) {
        userDAO.editUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
