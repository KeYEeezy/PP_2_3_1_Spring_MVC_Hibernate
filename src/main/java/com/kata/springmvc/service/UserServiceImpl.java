package com.kata.springmvc.service;

import com.kata.springmvc.dao.UserDAO;
import com.kata.springmvc.models.User;
import com.kata.springmvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findUser(Long id) {
        return userDAO.findUser(id);

    }

    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) {
        userDAO.updateUser(id,updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
