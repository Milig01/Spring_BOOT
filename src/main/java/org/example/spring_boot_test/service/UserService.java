package org.example.spring_boot_test.service;

import org.example.spring_boot_test.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findById(long id);
    void deleteById(long id);
}
