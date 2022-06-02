package es.danrivcap.cv.houseofcards.app.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import es.danrivcap.cv.houseofcards.app.Dealer;
import es.danrivcap.cv.houseofcards.app.Deck;
import es.danrivcap.cv.houseofcards.model.Card;
import es.danrivcap.cv.houseofcards.model.Face;
import es.danrivcap.cv.houseofcards.model.Suit;
import es.danrivcap.cv.houseofcards.model.poker.PokerFace;
import es.danrivcap.cv.houseofcards.model.poker.PokerSuit;

/**
 * Concrete implementation of a Deck with a random stack os poker cards
 * it implement concrete Poker Cards 
 * it deals card randomly  
 **/
public class RandomPokerDeck implements Deck<Suit,Face>{

	private static final int EMPTY = 0;
	/*This is the default size for a poker deck but there are packaged
	protected constructor whit could give other values for this value
	for testing purposes.
	*/
	//TODO: Move this to an common class to reuse in other decks every deck have a size
	private static final int DEFAULT_POKER_DECK_BOTTOM = 0;
	private static final int DEFAULT_POKER_DECK_SIZE = 52;
	private int deckSize = DEFAULT_POKER_DECK_SIZE;
	
	//Deck holder where cards lives, I preffer ArrayList over Arrays due to API Flexibility and generic type system facilities. 
	private ArrayList<Card<Suit,Face>> deck;
	
	//A dealer for selecting cards injected by DI
	private Dealer dealer;
	
	/**
	 * Initializes the deck so it is full of cards and its default values 
	 * The client will initialize the Dect by a Factory to abstract the details of the Dependencies for this reasons this method
	 * is private
	 **/
	public RandomPokerDeck() {
		deck = new ArrayList<>(DEFAULT_POKER_DECK_SIZE);
		build();
	}

	/**
	 * This constructor knows how to initialize a Dect with a Dealer with DI The Cilient will use a factory to create the Dect
	 * In order to get abstracted by the details of constructing the Dect and this dependencies.
	 * 
	 * This method is package protected because the factory is located in the same pacakage and we dont want anyone calling it 
	 * from outside and it allow to call the constructor from the test provided that the tests are in the same package as the class 
	 **/
	public RandomPokerDeck(Dealer dealer) {
		this();
		this.dealer = new RandomDealer(DEFAULT_POKER_DECK_BOTTOM,DEFAULT_POKER_DECK_SIZE);
		
	}
	
	/**
	 *Build internal Deck It could be delegated in a future to a external service if we want different building strategies 
	 ***/
	private void build() {
		Set<PokerSuit> suits = EnumSet.allOf(PokerSuit.class);
		Set<PokerFace> faces = EnumSet.allOf(PokerFace.class);
		for (PokerSuit suit : suits) {
			for (PokerFace face : faces) {
				Card<Suit, Face> card = new Card<>(suit,face);
				deck.add(card);
			}
		}
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
	public Optional<Card<Suit, Face>> dealOneCard() {
		if(deckSize != EMPTY){
			deckSize--;
			return Optional.of(deck.get(dealer.next()));
		}else {
			return Optional.empty();
		}
		
		
	}

}
