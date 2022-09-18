package com.petClinic.Pet.clinic.services;

import org.springframework.stereotype.Service;

import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.repositories.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

}
