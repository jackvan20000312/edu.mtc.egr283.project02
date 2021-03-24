package edu.mtc.egr283.project02;

public class ReturnCardMessage {

	private static String[] YELLOW_MESSAGES= {"Take a red card if you please. Hope you win this game with ease.",
			"Uncle Wiggily moves ahead by one. He takes a walk and has some fun.",
			"Uncle Wiggily hops forward by two. He moves right now and then he's through.",
			"How near the finish will you be? When Uncle Wiggily hops ahead three.",
			"Uncle Wiggily hops along by four. Now he likes you even more.",
			"He'd rather walk than take a drive. Uncle Wiggily jumps ahead by five.",
			"Move Uncle Wiggily forward by six. The clever rabbit knows all the tricks.",
			"Uncle Wiggily takes seven hops. He moves right now and then he stops.",
			"Hurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight.",
			"Uncle Wiggily hops ahead by nine. He thinks this game is really fine.",
			"Hope you get this card again! Uncle Wiggily goes ahead by ten."};
	
	private static String[] RED_MESSAGES= {
			"\nWe really hope you won't feel blue. But Uncle Wiggily must go back two.",
			"\nUncle Wiggily must jump back three. It's not the best place for him to be.",
			"\nUncle Wiggily must hop back four. Hope this won't happen any more.",
			"\nUncle Wiggily must go back five. Nobody knows when he will arrive.",
			"\nHurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight.",
			"\nUncle Wiggily hops ahead by nine. He thinks this game is really fine.",
			"\nHope you get this card again! Uncle Wiggily goes ahead by ten.",
			"\nA card this good is not often seen. Move Uncle Wiggily ahead by thirteen!",
			"\nUncle Wiggily hops ahead fifteen. You're one of the best he's ever seen!"};
	
	private static String[] SPECIAL_SQUARE_MESSAGES= {
			"Skillery Skallery Alligator, Lose 1 turn.",
			"Cluck Cluck Chicken House, go to space 100.",
			"Rabbit Hole, go back to space 13.",
			"Bow Wow Dog House, go to space 50.",
			"Woods, Lose 1 turn.",
			"Rabbit Hole, go back to space 13.",
			"Cluck Cluck Chicken House, go to space 100.",
			"The Bad Pipsisewah – Lose 2 turns.",
			"Wibble Wobble Duck Pond, go to space 60.",
			"Fox Den, Lose 2 turns.",
			"5 & 10 Cent Store, go to space 35.",
			"Trap, Lose 2 turns.",
			"Skeezicks, Lose 1 turn.",
			"Woods, Lose 1 turn.",
			"Bushytail Squirrel Tree, go to space 75.",
			"Trap, Lose 2 turns.",
			"5 & 10 Cent Store, go to space 35.",
			"Fox Den, Lose 2 turns."};
	
	private static int[] SPECIAL_SQUARE_LOCATIONS= {9,17,23,28,39,52,64,67,76,79,94,101,110,115,121,131,138,141};

	public static String returnRedMessage(int cardNumber) {
		return RED_MESSAGES[cardNumber];
	}//ending bracket of method returnRedMessage
	
	public static String returnYellowMessage(int cardNumber) {
		return YELLOW_MESSAGES[cardNumber];
	}//ending bracket of method returnYellowMessage
	
	public static String returnSquareMessage(Player player) {
		for(int i=0; i<SPECIAL_SQUARE_LOCATIONS.length; i++) {
			if (player.getSpace()==SPECIAL_SQUARE_LOCATIONS[i]) {
				return ("\nSpace "+SPECIAL_SQUARE_LOCATIONS[i]+" - "+player.getName()+"\n"+SPECIAL_SQUARE_MESSAGES[i]);
			}//end of if statement 
		}//end of for loop 
		return ("\nSpace "+player.getSpace()+" - "+player.getName());
	}//ending bracket of method returnSquareMessage

}//ending bracket of class ReturnCardMessage
