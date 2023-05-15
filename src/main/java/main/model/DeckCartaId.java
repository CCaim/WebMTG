package main.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DeckCartaId implements Serializable {
    
    private Long deckId;
    
    private Long cartaId;

	public DeckCartaId(Long deckId, Long cartaId) {
		super();
		this.deckId = deckId;
		this.cartaId = cartaId;
	}

	public Long getDeckId() {
		return deckId;
	}

	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

	public Long getCartaId() {
		return cartaId;
	}

	public void setCartaId(Long cartaId) {
		this.cartaId = cartaId;
	}
    
    
    
}
