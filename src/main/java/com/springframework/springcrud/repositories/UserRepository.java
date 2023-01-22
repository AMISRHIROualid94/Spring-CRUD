package com.springframework.springcrud.repositories;

import com.springframework.springcrud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
    User findUserByUsername(String username);
}
