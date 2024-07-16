package org.example.spring_boot_test.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_test.model.User;
import org.example.spring_boot_test.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public User findById(Long id) {
        return userDao.findById(id).get();
    }
}
