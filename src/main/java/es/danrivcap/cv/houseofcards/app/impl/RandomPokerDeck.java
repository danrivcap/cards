package es.danrivcap.cv.houseofcards.app.impl;

import java.util.ArrayList;
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

	private static final int EMPTY = 0;
	/*This is the default size for a poker deck but there are packaged
	protected constructor whit could give other values for this value
	for testing purposes.
	*/
	//TODO: Move this to an common class to reuse in other decks every deck have a size
	private static final int DEFAULT_POKER_DECK_SIZE = 52;
	private int deckSize = DEFAULT_POKER_DECK_SIZE;
	
	//Deck holder where cards lives, I preffer ArrayList over Arrays due to API Flexibility and generic type system facilities. 
	private ArrayList<Card<PokerSuit,PokerFace>> deck;
	
	/**
	 * Initializes the deck so it is full of cards and its default values 
	 **/
	public RandomPokerDeck() {
		deck = new ArrayList<>(DEFAULT_POKER_DECK_SIZE);
	}
	
	/***
	 * It is simply a reset of certain values such
	 * deckSize wich returns to its original value, its means all cards return to the deck
	 ***/
	@Override
	public void shufle() {
		deckSize = DEFAULT_POKER_DECK_SIZE;
		
	}


	@Override
	/**
	 * Deal a card in this case uses a external dealer wich uses a external random generator and decreases the size of the deck
	 * and returns a Card. When threre is no Card to return it return nothing.
	 * The dealer is external because you can select between different deal strategies random, in order, based in a predicate, 
	 * in this class is fixed but in ohters you can choose in construction time.
	 ***/
	public Optional<Card<PokerSuit, PokerFace>> dealOneCard() {
		if(deckSize != EMPTY){
			deckSize--;
			return Optional.of(deck.get(0));
		}else {
			return Optional.empty();
		}
		
		
	}

}
