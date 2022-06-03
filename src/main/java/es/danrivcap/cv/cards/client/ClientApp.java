package es.danrivcap.cv.houseofcards.client;

import java.util.Optional;

import es.danrivcap.cv.houseofcards.app.Dealer;
import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.app.impl.DeckFactory;
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
		Deck<Suit, Face> deck = DeckFactory.buildRandomPokerDect();
			
		for (int i = 0; i < 55; i++) {
			Optional<Card<Suit,Face>> oCard = deck.dealOneCard();
			//You can provide default card when you dont have more cads to obtain
			Card<Suit,Face> card = oCard.orElse(new Card<>(JokerSuit.JOKER, JokerFace.JOKER));
			System.out.println(card);
		}
		//you reset the deck calling shuffle
		deck.shufle();
		
		Optional<Card<Suit,Face>> oCard2 = deck.dealOneCard();
		//You can throw exeption when no card are available
		Card<Suit,Face> card2 = oCard2.orElseThrow();
		System.out.println(card2);
		
		//because shufle you can obtain more cards
		for (int i = 0; i < 55; i++) {
			Optional<Card<Suit,Face>> oCard3 = deck.dealOneCard();
			//You can provide default card when you dont have more cads to obtain
			Card<Suit,Face> card3 = oCard3.orElse(new Card<>(JokerSuit.JOKER, JokerFace.JOKER));
			System.out.println(card3);
		}
		
	}

}
