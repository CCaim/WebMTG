package main.modelo.dto;

import java.util.List;

import main.model.Carta;
import main.model.Deck;

public class DeckConstDTO {
	private List<Carta> cards;
	private Deck deck;

	public void addCard(Carta card) {
		this.cards.add(card);
	}

	public List<Carta> getCards() {
		return cards;
	}

	public void setCards(List<Carta> cards) {
		this.cards = cards;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	
}