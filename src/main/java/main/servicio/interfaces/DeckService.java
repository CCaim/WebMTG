package main.servicio.interfaces;

import java.util.List;

import main.model.Deck;

public interface DeckService {
	
	public Deck insertarDeck(Deck deck);
	
	public List<Deck> listarDeck();
	
	public Deck obtenerDeckPorNombre (String nombre);
	
	public void eliminarDeckPorId(Integer id);
}
