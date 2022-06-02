package es.danrivcap.cv.houseofcards.client;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.app.Dealer;
import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.app.impl.RandomDealer;
import es.danrivcap.cv.houseofcards.app.impl.RandomPokerDeck;
import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.Face;
import es.danrivcap.cv.houseofcards.model.Suit;
import es.danrivcap.cv.houseofcards.model.empty.JokerFace;
import es.danrivcap.cv.houseofcards.model.empty.JokerSuit;
import es.danrivcap.cv.houseofcards.model.poker.PokerSuit;
import es.danrivcap.cv.houseofcards.model.poker.PokerFace;

public class ClientApp {

	/**
	 * Client application which acts as a test for the specification of the problem
	 **/
	public static void main(String[] args) {
		Dealer dealer = new RandomDealer(0,52);
		for (int i = 0; i < 55; i++) {
			int v = dealer.next();
			System.out.println(i + " - " + v);
		}
	}

}
