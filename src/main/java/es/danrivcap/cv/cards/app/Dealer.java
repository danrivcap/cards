package es.danrivcap.cv.cards.app;

/**
 * Deals next number to obtain a Card based in a Strategy there would be different ways
 * * random ones which assures no duplication of numbers are supplied
 * * based in a Predicate to deliver only even or odd cards
 * * in order for testing purposes 
 * 
 * Dealers are like generators they generates ints till they exhausts (you can implement infinite Dealers if you need)
 * ireturning hasnext true.
 * 
 * It is not a generic class Dealer<T> because we only deal integers so it is a nonsense to deal other objects

 **/
public interface Dealer {

	int next();
	
	void reset();
	
	boolean hasNext();
	
}
