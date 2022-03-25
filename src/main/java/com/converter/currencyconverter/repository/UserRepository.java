package com.converter.currencyconverter.repository;

import com.converter.currencyconverter.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);        
    
}
