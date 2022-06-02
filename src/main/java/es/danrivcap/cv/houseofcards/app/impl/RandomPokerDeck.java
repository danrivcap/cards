package es.danrivcap.cv.houseofcards.app.impl;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.poker.PokerFace;
import es.danrivcap.cv.houseofcards.model.poker.PokerSuit;

/**
 * Concrete implementation of a Deck with a random stack os poker cards
 * it implement concrete Poker Cards 
 * it deals card randomly  
 **/
public class RandomPokerDeck implements Deck<PokerSuit,PokerFace>{

	
	
	
	
	@Override
	public void shufle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Card<PokerSuit, PokerFace>> dealOneCard() {
		
		return Optional.empty();
	}

}
