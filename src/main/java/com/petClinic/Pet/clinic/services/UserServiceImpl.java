package com.petClinic.Pet.clinic.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petClinic.Pet.clinic.dto.UserDTO;
import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.repositories.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public User getByEmail(String email) {
        User user = StreamSupport.stream(userRepository.findAll().spliterator(), true)
        .filter(x -> x.getEmail() == email)
        .findFirst().get();
        return user;
    }
    
    
    // @Override
    // public User getByEmail(String email) {
        //     return userRepository.).get();
        // }
    
    @Override
    // public User save(User user) throws exception {
    public User save(User user){
    //         if (userRepository.getByEmail(user.getEmail())!=null) {
    //             throw new Exception(
    //               "There is an account with that email adress:" + user.getEmail());
    //         }            
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

}
