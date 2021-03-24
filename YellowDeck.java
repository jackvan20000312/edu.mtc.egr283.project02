package edu.mtc.egr283.project02;

import java.util.Random;

public class YellowDeck {

	private static Yellows[] cards;
	private static Random randomizer;
	private static int numberOfCardsRemaining;
	
	public static final int DECK_SIZE = 11;
	
	public YellowDeck() {
		int arrayIndex = 0;
		YellowDeck.cards = new Yellows[YellowDeck.DECK_SIZE];
		YellowDeck.numberOfCardsRemaining = YellowDeck.DECK_SIZE;
		YellowDeck.randomizer = new Random();
		for(Yellows yellows : Yellows.values()) {
			YellowDeck.cards[arrayIndex++] = yellows;
		}//end of OUTER for loop - SUIT
	}//end of constructor
	
	//deals a card
	public Yellows deal() {
		Yellows rv = null;
		int index = -1;
		do {
			index = YellowDeck.randomizer.nextInt(YellowDeck.DECK_SIZE);
			rv = YellowDeck.cards[index];
		} while(rv == null);
		--YellowDeck.numberOfCardsRemaining;
		YellowDeck.cards[index] = null;
		return rv;
	}//end of method deal
	
	public int getNumberOfCardsRemaining() {
		return YellowDeck.numberOfCardsRemaining;
	}//end of method getNumberOfCardsRemaining
	
	public void displayDeck() {
		for(Yellows pc : YellowDeck.cards) {
			System.out.println(pc.toString());
		}//end of for loop 
	}//end of method displayDeck
}//end of class Deck