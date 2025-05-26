package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        Optional<User> result = userDAO.findById(id);
        return result.orElse(null);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.save(user);
    }
}
