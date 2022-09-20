package com.petClinic.Pet.clinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.annotation.security.RunAs;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.petClinic.Pet.clinic.dto.UserDTO;
import com.petClinic.Pet.clinic.model.Role;
import com.petClinic.Pet.clinic.model.User;
import com.petClinic.Pet.clinic.repositories.UserRepository;
import com.petClinic.Pet.clinic.services.UserService;
import com.petClinic.Pet.clinic.shared.GenericResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes = { SpringTest })
public class PetClinicApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TestRestTemplate testRestTemplate;

	@BeforeEach
	public void cleanup(){
		userRepository.deleteAll();
	}


	@Test
	public void postUser_whenUserIsValid_recieveOk(){
		User user = createUser();
		ResponseEntity<Object> responseEntity = testRestTemplate
			.postForEntity("/api/1.0/users", user, Object.class);
		System.out.println(responseEntity.getStatusCode());
		assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}

	private User createUser() {
		User user= new User();
		user.setEmail("abc@bca.com");
		user.setPassword("passw4rd");
		return user;
	}

	@Test
	public void postUser_userSavedInDB(){
		User user = createUser();
		testRestTemplate
			.postForEntity("/api/1.0/users", user, Object.class);
		assertEquals(1, userRepository.count());
	}

	@Test
	public void postUser_recieveBody(){
		User user = createUser();
		ResponseEntity<GenericResponse> responseEntity = testRestTemplate
			.postForEntity("/api/1.0/users", user, GenericResponse.class);
		assertNotNull(responseEntity.getBody());
	}

	

	// @Test
	// public void postUser_whenUserIsValid_passwordIsHasheedInDatabase(){
		// User user = 	
	// }

}
