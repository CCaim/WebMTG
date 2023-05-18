package main.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "cartas_decks")
public class CartasDecks {

    @EmbeddedId
    private CartasDecksId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartaId")
    private Carta carta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("deckId")
    private Deck deck;

    public CartasDecks() {
        this.id = new CartasDecksId();
    }

	public CartasDecksId getId() {
		return id;
	}

	public void setId(CartasDecksId id) {
		this.id = id;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Deck getDecks() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

    
}
