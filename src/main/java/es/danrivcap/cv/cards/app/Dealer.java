package es.danrivcap.cv.cards.app;

/**
 * Deals next number to obtain a Card based in a Strategy there would be diferent ways
 * * random ones wich assures no dupplication of numbers are supplied
 * * based in a Predicate to deliver only even or odd cards
 * * in order for testing purposes 
 **/
public interface Dealer {

	int next();
	
	void reset();
	
	boolean hasNext();
	
}
