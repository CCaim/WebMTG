package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	String home() {
		return "index";
	}
	
	
//	@GetMapping("/mazos")
//	String homeMazos() {
//		return "mazos";
//	}

}
