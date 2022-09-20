package com.petClinic.Pet.clinic.model;


import java.util.*;

import javax.persistence.*;
import javax.servlet.annotation.ServletSecurity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import lombok.*;



@Getter
@Setter
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name"})
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
