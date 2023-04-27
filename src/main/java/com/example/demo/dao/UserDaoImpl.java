package com.example.demo.dao;

import com.example.demo.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Transactional
    public User update(User userUpdate) {
       return entityManager.merge(userUpdate);
    }
    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
        entityManager.flush();
    }

}
