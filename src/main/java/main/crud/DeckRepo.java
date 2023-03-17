package main.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Deck;
import main.model.Rol;

public interface DeckRepo extends JpaRepository<Deck, Integer> {

	public Deck findByNombre(String nombre);

	

}
