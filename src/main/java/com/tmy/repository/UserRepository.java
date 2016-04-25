package com.tmy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmy.entry.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);

}
