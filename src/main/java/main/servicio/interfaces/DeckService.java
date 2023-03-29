package main.servicio.interfaces;

import java.util.List;

import main.model.Deck;
import main.model.Usuario;

public interface DeckService {
	
	public Deck insertarDeck(Deck deck);
	
	public List<Deck> listarDeck();
	
	public Deck findById (Integer id);
	
	public void eliminarDeckPorId(Integer id);

	List<Deck> obtenerDecksPorUsuario(Usuario usuario);
}
