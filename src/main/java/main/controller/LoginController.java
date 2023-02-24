package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

	@GetMapping(value = { "", "/" })
	String homeLogin(Model model) {

		return "login";
	}

	@PostMapping("/logout")
	public String editarAlumno(Model model) {

		return "redirect:/login";
	}
}