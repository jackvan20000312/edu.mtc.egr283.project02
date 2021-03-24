package edu.mtc.egr283.project02;

public enum Yellows {

	CARD1("CARD 1",1), CARD2("CARD 2",2), CARD3("CARD 3",3), CARD4("CARD 4",4), 
	CARD5("CARD 5",5), CARD6("CARD 6",6), CARD7("CARD 7",7), CARD8("CARD 8",8), 
	CARD9("CARD 9",9), CARD10("CARD 10",10), CARD11("CARD 11",11);
	
	private final String name;
	private final int number;
	
	private Yellows(String newName, int newSymbol) {
		
		this.name=newName;
		this.number=newSymbol;
	}//Ending bracket of constructor
	
	public String getCardName() {
		return this.name;
	}//Ending bracket of method getName
	
	//for use in Arrays
	public int getRankValue() {
		return this.number-1;
	}//ending bracket of method getSymbol
	
}//Ending Bracket of enum Rnak
