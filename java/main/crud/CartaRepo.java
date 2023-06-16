package main.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Carta;
import main.model.Deck;

public interface CartaRepo extends JpaRepository<Carta, Integer> {
	
	public Optional<Carta> findById(Integer id);
}
