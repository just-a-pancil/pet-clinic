package com.petClinic.Pet.clinic.controls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.services.UserService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class someController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User sayHello(@PathVariable Long id){
        return userService.getUser(id);
    }
    
}
