package org.example.spring_boot_test.repository;

import org.example.spring_boot_test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {}
