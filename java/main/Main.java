package main;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import main.crud.CartaRepo;
import main.crud.GenericDAO;
import main.model.Carta;
import main.model.Deck;
import main.model.Usuario;



@SpringBootApplication
public class Main extends SpringBootServletInitializer{
	
	public static <T> void main(String[] args) {
	
		
		SpringApplication.run(Main.class, args);
		
		
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
}

