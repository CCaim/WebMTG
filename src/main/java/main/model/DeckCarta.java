package main.model;

import java.util.ArrayList;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DeckCarta {
    
    @EmbeddedId
    private DeckCartaId id;
    
    @ManyToOne
    @MapsId("deckId")
    private Deck deck;
    
    @ManyToOne
    @MapsId("cartaId")
    private Carta carta;

	public DeckCarta(DeckCartaId id, Deck deck, Carta carta) {
		super();
		this.id = id;
		this.deck = deck;
		this.carta = carta;

	}

	public DeckCartaId getId() {
		return id;
	}

	public void setId(DeckCartaId id) {
		this.id = id;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}


	public ArrayList<Deck> getDecks() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
}
