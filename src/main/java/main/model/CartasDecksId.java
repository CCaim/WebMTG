package main.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CartasDecksId implements Serializable {

    private Long cartaId;
    private Long deckId;
    
	public Long getCartaId() {
		return cartaId;
	}
	public void setCartaId(Long cartaId) {
		this.cartaId = cartaId;
	}
	public Long getDeckId() {
		return deckId;
	}
	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

    
}
