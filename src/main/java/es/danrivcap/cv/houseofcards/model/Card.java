package es.danrivcap.cv.houseofcards.model;

import java.util.Objects;

/**
 * Inmutable representation of a Card oce build you can't change it's state
 * 
 * Whit this class you have the freedom to represent any kind of card is the deck responsability to validate
 * and build the total number of cards whit the correct faces and suits 
 * 
 * Whit modern java versions (JDK > 14) we can transform this class in a record and it will operate like a real
 * value object or like a struct in C#
 **/
public class Card {
	private String suit;
	
	private String face;

	public Card(String suit, String face) {
		super();
		this.suit = suit;
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public String getFace() {
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
		return "Card [suit=" + suit + ", face=" + face + "]";
	}
	
	
}
