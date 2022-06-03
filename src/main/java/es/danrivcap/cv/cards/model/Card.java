package es.danrivcap.cv.cards.model;

import java.util.Objects;

/**
 * Inmutable representation of a generic Card once build you can't change its state
 * 
 * Which this class you have the freedom to represent any kind of card is the deck responsibility to validate
 * and build the total number of cards with the correct faces and suits 
 * 
 * It is generic because you can implement with any Enum you want the suits and faces you need Poker or Spanish Cards
 * they are not subclass because Poker Cards or Spanish Cards don't have different behavior or shape, it is only a 
 * matter of constant or appearance that we can approach wich constants or enums for this reasons we are usings generics
 * and interfaces for restricting the kind of values we allow as suits and faces 
 * 
 * Whit modern java versions (JDK > 14) we can transform this class in a record and it will operate like a real
 * value object or like a struct in C#
 **/
public class Card<S extends Suit,F extends Face> {
	private S suit;
	
	private F face;

	public Card(S suit, F face) {
		super();
		this.suit = suit;
		this.face = face;
	}

	public S getSuit() {
		return suit;
	}

	public F getFace() {
		return face;
	}

	@Override
	public int hashCode() {
		return Objects.hash(face, suit);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(face, other.face) && Objects.equals(suit, other.suit);
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit.name() + ", face=" + face.name() + "]";
	}
	
	
}
