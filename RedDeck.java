package edu.mtc.egr283.project02;

import java.util.Random;

public class RedDeck {

	private static Reds[] cards;
	private static Random randomizer;
	private static int numberOfCardsRemaining;
	
	public static final int DECK_SIZE = 9;
	
	public RedDeck() {
		int arrayIndex = 0;
		RedDeck.cards = new Reds[RedDeck.DECK_SIZE];
		RedDeck.numberOfCardsRemaining = RedDeck.DECK_SIZE;
		RedDeck.randomizer = new Random();
		for(Reds reds : Reds.values()) {
				RedDeck.cards[arrayIndex++] = reds;
		}//end of OUTER for loop - SUIT
	}//end of constructor
	
	//deals a card
	public Reds deal() {
		Reds rv = null;
		int index = -1;
		do {
			index = RedDeck.randomizer.nextInt(RedDeck.DECK_SIZE);
			rv = RedDeck.cards[index];
		}while(rv == null);
		--RedDeck.numberOfCardsRemaining;
		RedDeck.cards[index] = null;
		return rv;
	}//end of method deal
	
	public int getNumberOfCardsRemaining() {
		return RedDeck.numberOfCardsRemaining;
	}//end of method getNumberOfCardsRemaining
	
	public void displayDeck() {
		for(Reds pc : RedDeck.cards) {
			System.out.println(pc.toString());
		}//end of for loop 
	}//end of method displayDeck
}//end of class Deck