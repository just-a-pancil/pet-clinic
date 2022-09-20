package com.petClinic.Pet.clinic.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.petClinic.Pet.clinic.dto.UserDTO;
import com.petClinic.Pet.clinic.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    UserDTO toDTO(User user);       
}
