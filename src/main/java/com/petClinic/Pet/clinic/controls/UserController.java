package com.petClinic.Pet.clinic.controls;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petClinic.Pet.clinic.dto.RoleDTO;
import com.petClinic.Pet.clinic.dto.UserDTO;
import com.petClinic.Pet.clinic.mappers.UserMapper;
import com.petClinic.Pet.clinic.model.Role;
import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.services.UserService;
import com.petClinic.Pet.clinic.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO sayHello(@PathVariable Long id){
        User user = userService.getById(id);
        return UserMapper.INSTANCE.toDTO(user);
    } 


    @PostMapping("/api/1.0/users")
    GenericResponse createUser(@RequestBody User user) {
    // void createUser(@RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User created");
    }
}
