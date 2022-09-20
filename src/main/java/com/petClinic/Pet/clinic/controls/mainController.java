package com.petClinic.Pet.clinic.controls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

	@GetMapping("/")
	public String greeting( Model model) {
		model.addAttribute("title", "Main Page");
		return "home";
	}	

		

}