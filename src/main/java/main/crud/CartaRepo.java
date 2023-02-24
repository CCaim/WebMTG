package main.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Carta;

public interface CartaRepo extends JpaRepository<Carta, Integer> {
	
	//public Optional<Carta> findByNname(String Nname);
}
