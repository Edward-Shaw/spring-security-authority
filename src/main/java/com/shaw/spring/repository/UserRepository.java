package com.shaw.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaw.spring.resource.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);

}
