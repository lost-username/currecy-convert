package com.converter.currencyconverter.service;

import java.util.Optional;

import com.converter.currencyconverter.domain.User;
import com.converter.currencyconverter.repository.UserRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + UserService.class.getName(), null));
    }


    public User findByEmail(String email) {
        User findByEmail = userRepository.findByEmail(email);
        if(findByEmail == null){
            return null;
        } else return findByEmail;
       // return findByEmail.orElseThrow(() -> new ObjectNotFoundException("Email not found! Email: " + email + ", Type: " + UserService.class.getName(), null));
       
    }
    public User save(User user) {
       return userRepository.save(user);
    
    }
   
    
}
