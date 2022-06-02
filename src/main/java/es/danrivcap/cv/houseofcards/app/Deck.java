package es.danrivcap.cv.houseofcards.app;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.poker.Face;
import es.danrivcap.cv.houseofcards.model.poker.Suit;

/**
 * Public contract of a card Deckt, it could be multiple implementations of a Deck in shape (Pocker, Spanish) and
 * in implementation details with a fixed array or a real stack.
 * 
 * It is generic to support cards of any kind of face or suit
 **/
public interface Deck<S extends Enum<S>,T extends Enum<T>> {

	/**
	 * disorer all the cards of the deck is like a init the deck
	 ***/
	void shufle();
	
	/**
	 *Returns a card from the deck and nothing where no more cards are available	
	 *never returns a duplicate card
	 **/
	Optional<Card<S,T>>dealOneCard();
	
}
