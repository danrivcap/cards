package es.danrivcap.cv.houseofcards.app.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import es.danrivcap.cv.houseofcards.app.Dealer;

public class RandomDealer implements Dealer {

	private int min;
	private int max;
	private Set<Integer> duplicateBag;
	private Random random; 
	
	public RandomDealer() {
		this.duplicateBag = new HashSet<>();
		this.random = new Random();
	}
	
	public RandomDealer(int min, int max) {
		this();
		this.min = min;
		this.max = max;
	}
	
	@Override
	public int next() {
		boolean isNotPresent = false;
		int selectedNumber = 0;
		while(!isNotPresent) {
			selectedNumber = min + random.nextInt(max);
			isNotPresent = this.duplicateBag.add(selectedNumber);
		}		
		return selectedNumber;
	}

}
