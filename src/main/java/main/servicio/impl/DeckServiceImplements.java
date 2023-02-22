package main.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.crud.DeckRepo;
import main.model.Deck;

@Service
public class DeckServiceImplements {

	@Autowired
	private DeckRepo deckRepo;
	
	
	public Deck insertarDeck(Deck deck) {
		
		deckRepo.save(deck);
		return null;
	}
	
	public List<Deck> listarDeck(){
		return deckRepo.findAll();
	}
	
	public Deck obtenerDeckPorNombre(String nombre) {
		return deckRepo.findByNombre(nombre).get();
	}
	
	public Deck obtenerDeckPorId(Integer id) {
		return deckRepo.findById(id).get();
	}
	public void eliminarDeck(Deck deck) {
		deckRepo.delete(deck);
	}
	public void elimminarDeckPorId(Integer id) {
		deckRepo.delete(deckRepo.findById(id).get());
	}
}
