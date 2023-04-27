package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User update(User userUpdate) {
        return userDao.update(userUpdate);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
