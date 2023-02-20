package com.kata.springmvc.dao;

import com.kata.springmvc.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    public List<User> findAll() {
        return em.createQuery("from User ").getResultList();
    }

    public User findUser(Long id) {
        return em.find(User.class, id);
    }

    public void saveUser(User user) {
        em.persist(user);

    }

    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void deleteUser(Long id) {
        em.remove(em.find(User.class, id));
    }
}
