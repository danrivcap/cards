package es.danrivcap.cv.cards.app.impl;

import es.danrivcap.cv.cards.app.Dealer;
import es.danrivcap.cv.cards.app.Deck;
import es.danrivcap.cv.cards.model.Face;
import es.danrivcap.cv.cards.model.Suit;

/***
 * Factory class to create different implementations of a Deck and decouple the client of the implementation 
 * it is a static factory because this factory doesn't need any state so it is ok not to maintain OOP here.
 * 
 * This is like this because I don't have Spring here but this is like an Application Context

 ***/
public class DeckFactory {

	private static final int DEALER_MAX = 52;
	private static final int DEALER_MIN = 0;

	private DeckFactory() {} //<-- noone want an instance of this
	
	/**
	 * Returns a Deck Interface with generic Suit and Faces the client can call public methods but never knows anything about
	 * details of the implementation.
	 ***/
	public static Deck<Suit,Face> buildRandomPokerDect() {
		//Hides dealer config from the client, 
		Dealer dealer = new RandomDealer(DEALER_MIN, DEALER_MAX);
		//Hided the details of kind of card and kind of dealing such cards clients obtain only an interface
		return new RandomPokerDeck(dealer);
		
		
	}
	
}
