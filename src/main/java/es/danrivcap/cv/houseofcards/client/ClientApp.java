package es.danrivcap.cv.houseofcards.client;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.app.impl.RandomPokerDeck;
import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.Face;
import es.danrivcap.cv.houseofcards.model.Suit;
import es.danrivcap.cv.houseofcards.model.poker.PokerSuit;
import es.danrivcap.cv.houseofcards.model.poker.PokerFace;

public class ClientApp {

	/**
	 * Client application which acts as a test for the specification of the problem
	 **/
	public static void main(String[] args) {
		Deck<Suit,Face> deck = new RandomPokerDeck();

		Optional<Card<Suit, Face>> optionalCard = deck.dealOneCard();
		 optionalCard = deck.dealOneCard();
		
		 
		 
		System.out.println(optionalCard.get());
	}

}
