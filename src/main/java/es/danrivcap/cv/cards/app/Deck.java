package es.danrivcap.cv.cards.app;

import java.util.Optional;

import es.danrivcap.cv.cards.model.Card;
import es.danrivcap.cv.cards.model.Face;
import es.danrivcap.cv.cards.model.Suit;

/**
 * Public contract of a card Deckt, it could be multiple implementations of a Deck in shape (Pocker, Spanish) and
 * in implementation details with a fixed array or a real stack.
 * 
 * It is generic to support cards of any kind of face or suit in the correct order thank to the interfaces
 **/
public interface Deck<S extends Suit ,F extends Face> {

	/**
	 * disorer all the cards of the deck is like a init the deck
	 ***/
	void shufle();
	
	/**
	 *Returns a card from the deck and nothing where no more cards are available	
	 *never returns a duplicate card.
	 *Optional allow client control of not card deal in a cleanner way than an Exception or a null
	 **/
	Optional<Card<S,F>>dealOneCard();
	
}
