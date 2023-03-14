package main.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.Deck;
import main.servicio.interfaces.DeckService;
import main.crud.DeckRepo;

public class DeckServiceImplements implements DeckService{
	
	@Autowired
	private DeckRepo DeckRepo;
	
	@Override
	public Deck insertarDeck(Deck deck) {
		Deck newDeck = new Deck();
		return DeckRepo.save(newDeck);
	}

	@Override
	public List<Deck> listarDeck() {
		// TODO Auto-generated method stub
		return DeckRepo.findAll();
	}

	@Override
	public Deck obtenerDeckPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return DeckRepo.obtenerDeckPorNombre(nombre);
	}

	@Override
	public void eliminarDeckPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
