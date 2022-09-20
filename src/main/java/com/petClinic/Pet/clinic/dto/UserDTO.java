package com.petClinic.Pet.clinic.dto;


import java.util.Set;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private Set<RoleDTO> roles; 
}
