package main.crud;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.model.Deck;
import main.model.Rol;
import main.model.Usuario;

public interface DeckRepo extends JpaRepository<Deck, Integer> {
	
    public Optional<Deck> findById(Integer id);
    
//    @Transactional
//    @Query("DELETE FROM ncards_decks WHERE decks_id = ?1 ")
//    public void deleteByDeckId(Integer id);

	public List<Deck> findByUsuario(Usuario usuario);
}

