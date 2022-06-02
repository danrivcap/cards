package es.danrivcap.cv.houseofcards.client;

import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.poker.PokerSuit;
import es.danrivcap.cv.houseofcards.model.poker.PokerFace;

public class ClientApp {

	/**
	 * Client application which acts as a test for the specification of the problem
	 **/
	public static void main(String[] args) {
		Card card = new Card<PokerSuit,PokerFace>(PokerSuit.CLUB,PokerFace.TWO);

		System.out.println(card);
	}

}
