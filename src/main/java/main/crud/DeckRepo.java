package main.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Deck;

public interface DeckRepo extends JpaRepository<Deck, Integer> {

	

}
