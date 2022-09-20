package com.petClinic.Pet.clinic.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.repositories.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user){
        return userRepository.save(user);

    }

}
