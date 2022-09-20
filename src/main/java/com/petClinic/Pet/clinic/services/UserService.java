package com.petClinic.Pet.clinic.services;

import com.petClinic.Pet.clinic.model.User;

public interface UserService {
    User getById(Long id);
    User save(User user);
}
