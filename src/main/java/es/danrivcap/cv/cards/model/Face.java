package es.danrivcap.cv.cards.model;

/**
 * Marker interface to avoid Cards to have Suits where Faces 
 ***/
public interface Face {

	/**
	 *It is supposed to be implemented by an enum so we want to expose this Enum API to be used later in toString methods
	 **/
	String name();
	
}
