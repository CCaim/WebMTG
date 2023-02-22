package main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.crud.CartaRepo;
import main.crud.GenericDAO;
import main.model.Carta;
import main.model.Deck;
import main.model.Usuario;
@SpringBootApplication
public class Main {
	public static <T> void main(String[] args) {
		
//		Deck deck1 = new Deck();
//		
//		GenericDAO<Deck> genericDAODeck = new GenericDAO(Deck.class);
//		GenericDAO<Carta> genericDAOCarta = new GenericDAO(Carta.class);
//		deck1.setNombre("erequetenue2");
//		Carta carta = genericDAOCarta.buscarPorId(6);
//		deck1.getCartas().add(carta);
//		
//		
//		
//		genericDAODeck.insertarRegistroJPA(deck1);
//	
//		ArrayList<Deck> user = genericDAODeck.listarRegistros("Deck");
//	
		
		SpringApplication.run(Main.class, args);
		
		
	}
	
}

