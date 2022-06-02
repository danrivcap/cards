package es.danrivcap.cv.houseofcards.app.impl;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.poker.Face;
import es.danrivcap.cv.houseofcards.model.poker.Suit;

public class RandomPokerDeck implements Deck<Suit,Face>{

	
	
	@Override
	public void shufle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Card<Suit, Face>> dealOneCard() {
		
		return Optional.empty();
	}

}
