package edu.mtc.egr283.project02;

public enum Reds {
	
	CARD1("CARD 1",1), CARD2("CARD 2",2), CARD3("CARD 3",3), CARD4("CARD 4",4), CARD5("CARD 5",5), CARD6("CARD 6",6), CARD7("CARD 7",7), CARD8("CARD 8",8), CARD9("CARD 9",9);
	
	private final String cardNumber;
	private final int cardMessage;
	
	private Reds(String newCardNumber, int newCardMessage) {
		this.cardNumber = newCardNumber;
		this.cardMessage=newCardMessage;
	}//Ending bracket of constructor
	
	public String getCardSpace() {
		return this.cardNumber;
	}//Ending bracket of method getSuit
	
	public int getRankValue() {
		return this.cardMessage-1;
	}//ending bracket of method getSYmbol
}//Ending bracket of enum suit