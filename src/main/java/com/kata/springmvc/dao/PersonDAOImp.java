package com.kata.springmvc.dao;

import com.kata.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Repository
public class PersonDAOImp implements UserDAO {

    private final EntityManager em;

    @Autowired
    public PersonDAOImp(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<User> allUsers() {
        return em.createQuery("from User ").getResultList();
    }

    @Transactional
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void addUser(User user) {
        em.persist(user);

    }

    @Transactional
    public void editUser(Long id, User updatedUser) {
        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    public void deleteUser(Long id) {
        em.remove(em.find(User.class, id));
    }
}
