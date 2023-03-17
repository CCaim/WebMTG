package main.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Deck;
import main.servicio.interfaces.DeckService;
import main.crud.DeckRepo;

@Service
public class DeckServiceImplements implements DeckService {

	@Autowired
	private DeckRepo DeckRepo;

	@Override
	public Deck insertarDeck(Deck deck) {
		Deck newDeck = new Deck();
		newDeck.setNombre(deck.getNombre());
		newDeck.setCartas(deck.getCartas());
		return DeckRepo.save(newDeck);
	}

	@Override
	public List<Deck> listarDeck() {
		// TODO Auto-generated method stub
		return DeckRepo.findAll();
	}

	

	@Override
	public void eliminarDeckPorId(Integer id) {
	    // Primero eliminamos los registros relacionados en la tabla decks_cartas
	    Deck deck = DeckRepo.findById(id).orElseThrow(() -> new RuntimeException("Deck no encontrado"));
	    deck.getCartas().clear();
	    DeckRepo.save(deck);

	    // Luego eliminamos el Deck
	    DeckRepo.deleteById(id);
	}

	@Override
	public Deck findById(Integer id) {
	    Optional<Deck> optionalDeck = DeckRepo.findById(id);
	    if (optionalDeck.isPresent()) {
	        return optionalDeck.get();
	    } else {
	        return null;
	    }
	}


}
