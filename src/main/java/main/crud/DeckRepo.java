package main.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Deck;
import main.model.Rol;
import main.model.Usuario;

public interface DeckRepo extends JpaRepository<Deck, Integer> {
	
    public Optional<Deck> findById(Integer id);

	public List<Deck> findByUsuario(Usuario usuario);
}

