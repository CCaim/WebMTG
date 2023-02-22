package main.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Deck;

public interface DeckRepo extends JpaRepository<Deck, Integer> {

	public Optional<Deck> findByNombre(String nombre);

	

}
