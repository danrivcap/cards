package es.danrivcap.cv.houseofcards.app;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.model.Card;

/**
 * Public contract of a card Deckt, it could be multiple implementations of a Deck in shape (Pocker, Spanish) and
 * in implementation details with a fixed array or a real stack  
 **/
public interface Deck {

	/**
	 * disorer all the cards of the deck is like a init the deck
	 ***/
	void shufle();
	
	/**
	 *Returns a card from the deck and nothing where no more cards are available	
	 *never returns a duplicate card
	 **/
	Optional<Card> dealOneCard();
	
}
