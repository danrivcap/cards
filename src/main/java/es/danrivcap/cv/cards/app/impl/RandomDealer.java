package es.danrivcap.cv.cards.app.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import es.danrivcap.cv.cards.app.Dealer;

public class RandomDealer implements Dealer {

	private int min;
	private int max;
	private Set<Integer> duplicateBag;
	private Random random; 
	
	public RandomDealer() {
		reset();
		this.random = new Random();
	}
	
	public RandomDealer(int min, int max) {
		this();
		this.min = min;
		this.max = max;
	}
	
	@Override
	/**
	 * We deliver a random integer and control it is unique in a set, we control invariants not to get an infinite loop in runtime in the case anyone asks for more numbers in a set.  
	 **/
	public int next() {
		if (!hasNext()) {throw new IllegalStateException("duplicate bag is full of numbers. Application is missconfigured there are trying to deal more numbers than cards are available");}
		
		boolean isNotPresent = false;
		int selectedNumber = 0;
		while(!isNotPresent) {
			selectedNumber = min + random.nextInt(max);
			isNotPresent = this.duplicateBag.add(selectedNumber);
		}		
		return selectedNumber;
	}

	@Override
	public void reset() {
		this.duplicateBag = new HashSet<>();
	}

	@Override
	public boolean hasNext() {
		return (max - min) != duplicateBag.size();
	}

}
