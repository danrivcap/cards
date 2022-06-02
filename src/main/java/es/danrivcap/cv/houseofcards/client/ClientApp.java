package es.danrivcap.cv.houseofcards.client;

import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.poker.Suit;
import es.danrivcap.cv.houseofcards.model.poker.Face;

public class ClientApp {

	/**
	 * Client application which acts as a test for the specification of the problem
	 **/
	public static void main(String[] args) {
		Card card = new Card<Suit,Face>(Suit.CLUB,Face.ACE);

		System.out.println(card);
	}

}
