package com.petClinic.Pet.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petClinic.Pet.clinic.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
