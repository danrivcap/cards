package es.danrivcap.cv.houseofcards.model;

import java.util.Objects;

/**
 * Inmutable representation of a generic Card once build you can't change it's state
 * 
 * Which this class you have the freedom to represent any kind of card is the deck responsability to validate
 * and build the total number of cards whit the correct faces and suits 
 * 
 * It is generic because you can implement with any Enum you want the suits and faces you need Poker or Spanish Cards
 * 
 * Whit modern java versions (JDK > 14) we can transform this class in a record and it will operate like a real
 * value object or like a struct in C#
 **/
public class Card<S extends Enum<S>,T extends Enum<T>> {
	private S suit;
	
	private T face;

	public Card(S suit, T face) {
		super();
		this.suit = suit;
		this.face = face;
	}

	public S getSuit() {
		return suit;
	}

	public T getFace() {
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
