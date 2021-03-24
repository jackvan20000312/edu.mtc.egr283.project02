package edu.mtc.egr283.project02;

public class PickACard {

	static final String SKIP_NEXT_TURN =", sorry, you still have to skip your turn. \nYou are still on Space: ";
	static final String ALREADY_WON =", You Already Won.";
	static final int[] HOW_MANY_MOVES_TO_MAKE_ON_EACH_RED_SQUARE = {-2,-3,-4,-5,8,9,10,13,15};
	
	public static String start(Player inputPlayer, YellowDeck yellowDeck, RedDeck redDeck ) {
		String returnString="Error-start?";
		String alreadywon = inputPlayer.getName()+ALREADY_WON;
		if(inputPlayer.getSpace()>=152) {
			inputPlayer.setHasWonYet(true);
			return alreadywon;
		}//ending bracket of if statement
		
		if(inputPlayer.getSkips()>0) {
			inputPlayer.removeASkip();
			return inputPlayer.getName()+SKIP_NEXT_TURN+inputPlayer.getSpace();
		}//ending bracket of if statement
		
		if (inputPlayer.getSpace()<=0) {
			inputPlayer.setSpace(1);
		}//sets new players on space 1 and makes sure that players do not go to negative spaces.

		if(yellowDeck.getNumberOfCardsRemaining()==0) {
			System.out.println("Shuffled Yellow Deck.\n");
			yellowDeck=new YellowDeck();
		}//ending bracket of if statement
		
		if(redDeck.getNumberOfCardsRemaining()==0) {
			System.out.println("Shuffled Red Deck.\n");
			redDeck=new RedDeck();
		}//shuffles both decks if they are empty
		int cardpulledfromdeck=-1;
		cardpulledfromdeck=yellowDeck.deal().getRankValue();
		if (cardpulledfromdeck==0) {
			returnString=ReturnCardMessage.returnYellowMessage(cardpulledfromdeck);
			cardpulledfromdeck=redDeck.deal().getRankValue();//set temp variable to value of card
			returnString=returnString + ReturnCardMessage.returnRedMessage(cardpulledfromdeck);//edit return string
			inputPlayer.addSpaces(HOW_MANY_MOVES_TO_MAKE_ON_EACH_RED_SQUARE[cardpulledfromdeck]);//add spaces to player
			if (inputPlayer.getSpace()<=0) {
				inputPlayer.setSpace(1);
			}//ending bracket of if statement
		}//ending bracket of if statement
		
		else {
			returnString=ReturnCardMessage.returnYellowMessage(cardpulledfromdeck);
			inputPlayer.addSpaces(cardpulledfromdeck);//add spaces to player
			
			if (inputPlayer.getSpace()<=0) {
				inputPlayer.setSpace(1);
			}//ending bracket of if statement
		}//end of else
		returnString=returnString + specialSquares(inputPlayer);
		if (inputPlayer.getSpace()>=152) {
			returnString = returnString+" \n"+inputPlayer.getName()+" won.";
			inputPlayer.addAWin();
			inputPlayer.setHasWonYet(true);
		}//safety catch, may change if professor tells me how game works.
		return returnString;
	}//end of method start
	
	private static int[] SPECIAL_SQUARE_LOCATIONS= {9,17,23,28,39,52,64,67,76,79,94,101,110,115,121,131,138,141};
	private static int[] LOSE_A_TURN_SQUARES= {9,39,67,79,101,110,115,131,141};
	private static int[] LOSE_A_TURN_AMOUNT= {1,1,2,2,2,1,1,2,2};
	private static int[] GO_BACK_TO_SQUARE_ARRAY= {0,100,13,50,0,13,100,0,60,0,35,0,0,0,75,0,35,0};
	
	public static String specialSquares(Player player) {
		String returnString="Error-special squares";
		for(int i=0; i<SPECIAL_SQUARE_LOCATIONS.length; i++) {
			if (player.getSpace()==SPECIAL_SQUARE_LOCATIONS[i]) {
				for(int j=0; j<LOSE_A_TURN_SQUARES.length; j++) {
					if(player.getSpace()==LOSE_A_TURN_SQUARES[j]) {
						returnString=ReturnCardMessage.returnSquareMessage(player);
						player.addSkips(LOSE_A_TURN_AMOUNT[j]);
						return returnString;
					}//end of if statement 
				}//end of for loop 
				returnString=(ReturnCardMessage.returnSquareMessage(player));
				player.setSpace(GO_BACK_TO_SQUARE_ARRAY[i]);
				returnString=returnString+ReturnCardMessage.returnSquareMessage(player);
				return returnString;
			}//end of if statement 
		}//end of for loop 
		return ReturnCardMessage.returnSquareMessage(player);
	}//end of method specialSquares
}//end of class PickACard
