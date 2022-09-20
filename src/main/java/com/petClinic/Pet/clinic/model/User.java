package com.petClinic.Pet.clinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import lombok.*;



@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"email"})
public class User { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
 
    public void addRole(Role role) {
      roles.add(role);
      role.getUsers().add(this);
	}

	public void removeRole(Role role) {
		roles.remove(role);
		role.getUsers().remove(this);
	}

}
