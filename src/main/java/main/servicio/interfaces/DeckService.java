package main.servicio.interfaces;

import java.util.List;

import main.model.Deck;

public interface DeckService {

	public Deck insertarDeck (Deck deck);
	
	public List<Deck> listarDecks();
	
	public Deck obtenerDeckPorId (Integer id);
	
	public Deck obtenerDeckPorNombre (String nombre);
	
	public void eliminarDeck (Deck deck);
	
	public void eliminarUsuarioPorId (Integer id);
}
