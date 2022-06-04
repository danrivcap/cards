package es.danrivcap.cv.cards.client;

import java.util.Optional;

import es.danrivcap.cv.cards.app.Dealer;
import es.danrivcap.cv.cards.app.Deck;
import es.danrivcap.cv.cards.app.impl.DeckFactory;
import es.danrivcap.cv.cards.app.impl.RandomDealer;
import es.danrivcap.cv.cards.app.impl.RandomPokerDeck;
import es.danrivcap.cv.cards.model.Card;
import es.danrivcap.cv.cards.model.Face;
import es.danrivcap.cv.cards.model.Suit;
import es.danrivcap.cv.cards.model.empty.JokerFace;
import es.danrivcap.cv.cards.model.empty.JokerSuit;
import es.danrivcap.cv.cards.model.poker.PokerSuit;
import es.danrivcap.cv.cards.model.poker.PokerFace;

public class ClientApp {

	/**
	 * Client application which acts as a test for the specification of the problem
	 **/
	public static void main(String[] args) {
		Deck<Suit, Face> deck = DeckFactory.buildRandomPokerDect();
		System.out.println("Calling it 55 times");
		for (int i = 0; i < 55; i++) {
			Optional<Card<Suit, Face>> oCard = deck.dealOneCard();
			// You can provide default card when you dont have more cads to obtain
			Card<Suit, Face> card = oCard.orElse(new Card<>(JokerSuit.JOKER, JokerFace.JOKER));
			System.out.println((i + 1) + " - " + card);
		}
		// you reset the deck calling shuffle
		System.out.println("Calling shuffle");
		deck.shufle();
		System.out.println("Calling it several times to see it deal some new cards");
		Optional<Card<Suit, Face>> oCard2 = deck.dealOneCard();
		// You can throw exeption when no card are available be carefull java > 1.8 have elsethrow with no args 
		try {
			Card<Suit, Face> card2 = oCard2.orElseThrow(()->new Exception("No more cards available"));
			System.out.println(card2);
		}catch(Exception e){
			System.out.println("Enter here where no cards for deal");
		}

		System.out.println("Calling it 55 times and we notice it deals JOKER card earlier than before");
		// because shufle you can obtain more cards
		for (int i = 0; i < 55; i++) {
			Optional<Card<Suit, Face>> oCard3 = deck.dealOneCard();
			// You can provide default card when you dont have more cads to obtain
			Card<Suit, Face> card3 = oCard3.orElse(new Card<>(JokerSuit.JOKER, JokerFace.JOKER));
			System.out.println((i + 1) + " - " + card3);
		}

		try {
			Optional<Card<Suit, Face>> oCard3 = deck.dealOneCard();
			Card<Suit, Face> card4 = oCard3.orElseThrow(()->new Exception("No more cards available"));
		} catch (Exception e) {
			System.out.println("We decided to managed this as an exception in the optional " + e.getMessage());
			e.printStackTrace(System.err);
		}
		deck.shufle();
		System.out.println("We decided to do a shuffle");

		try {
			Optional<Card<Suit, Face>> oCard3 = deck.dealOneCard();
			Card<Suit, Face> card4 = oCard3.orElseThrow(()->new Exception("No more cards available"));
			System.out.println(card4);
			System.out.println("Now there are a valid card neirther an exeption neither a Joker");
		} catch (Exception e) {
			System.out.println("We decided to managed this as an exception in the optional " + e.getMessage());
			e.printStackTrace(System.err);
		}

	}

}
