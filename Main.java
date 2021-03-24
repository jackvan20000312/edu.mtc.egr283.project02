package edu.mtc.egr283.project02;

import javax.swing.JOptionPane;
//****************************************************************************************
//Author: Jacob Vaught       Modified: 1/29/2021  02/02/2021  
//
//EGR-283  Project 02  			  Due: 2/03/2021 6:00 PM
//****************************************************************************************
public class Main {
	private static int PLAYER_NUMBER=4;
	static int [][] array;
	static RedDeck yellowdeck=new RedDeck();
	static YellowDeck reddeck=new YellowDeck();
	final static String FIRST =" 1st Place |";
	final static String SECOND =" 2nd Place |";
	final static String THIRD =" 3rd Place |";
	final static String FOURTH =" 4th Place |";
	final static int NUMBEROFGAMES =10;

	public static void main(String[] args) {

		array= new int[NUMBEROFGAMES][PLAYER_NUMBER];
		int continueOrNot = JOptionPane.showConfirmDialog(null, "Would you Like To Play?");
		if (continueOrNot==0) {
			Player[] player=new Player[PLAYER_NUMBER];
			//gets player names
			for(int i=0; i<PLAYER_NUMBER; ++i) {
				player[i] = new Player(JOptionPane.showInputDialog("Please enter the player # "+(i+1)+"'s name."));
			}//ending bracket of  for loop
			
			for(int j=0; j<NUMBEROFGAMES; j++) {
				int[] playerArray = {-1,-1,-1,-1};
				boolean rv = false;
				int howManyWinners = 0;
				
				for(int i=0; i<PLAYER_NUMBER; i++) {
					player[i].startNewGame();
				}//ending bracket of for statement
				
				do {
					
					for(int i=0; i<PLAYER_NUMBER; i++) {
						System.out.println(PickACard.start(player[i], reddeck, yellowdeck));
						System.out.println();

						if(i!=playerArray[0]&&i!=playerArray[1]&&i!=playerArray[2]&&i!=playerArray[3]) {
							if(player[i].getHasWonYet()) {
								howManyWinners++;
								playerArray[i]=i;
								array[j][i]=howManyWinners;
							}//ending bracket of if statement
						}//ending bracket of if statement
						
						//checks if there are at least 4 winners so new game can start
						if(howManyWinners>=PLAYER_NUMBER) {
							rv=true;
							break;
						}//ending bracket of if statement
						
					}//ending bracket of  for loop
					
				}while(!rv);
				System.out.println("Game #"+(j+1)+" just ended!!!");
				
			}//ending bracket of  for loop
			
			for(int j=0; j<PLAYER_NUMBER; j++) {
				System.out.println("Player #"+(j+1)+" is "+player[j].getName());
			}//ending bracket of  for loop
			printMessage(array);
			print2ndMessage(array);
		}//ending bracket of if statement
		
		else if (continueOrNot==1) {
			System.exit(0);
			//end program
		}//ending bracket of else if statement
		
		else {
			System.exit(0);
		}//ending bracket of else	
	}//ending bracket of main method
	
	public static void printMessage(int[][] array) {
		System.out.println( "  Player 1 |  Player 2 |  Player 3 |  Player 4 |");
		for(int i=0; i<NUMBEROFGAMES; i++) {
			String returnString = "";
			for(int j=0; j<PLAYER_NUMBER; j++) {
				switch(array[i][j]) {
				case 1:
					returnString=returnString+FIRST;
					break;
				case 2:
					returnString=returnString+SECOND;
					break;
				case 3:
					returnString=returnString+THIRD;
					break;
				case 4:
					returnString=returnString+FOURTH;
					break;
				default:
					returnString=returnString+"ERROR";
					break;
				}//ending bracket of switch statement
			}//ending bracket of  for loop
			System.out.println(returnString+" Game #"+(i+1));
		}//ending bracket of  for loop
		System.out.println("/!#|*|#!/!#|*|#!/!#|*|#!/!#|*|#!/!#|*|#!/!#|*|#!/!#|*|#!/");
		System.out.println();
	}//ending bracket of main method
	
	public static void print2ndMessage(int[][] array) {
		for(int k=1; k<5; k++) {
			for(int j=0; j<PLAYER_NUMBER; j++) {
				int addition=0;
				for(int i=0; i<NUMBEROFGAMES; i++) {
					if(array[i][j]==k) {
						addition++;
					}//ending bracket of if statement
				}//ending bracket of  for loop
				System.out.println("Player #"+(j+1)+" won #"+k+" place "+addition+" times");
			}//ending bracket of  for loop
			System.out.println("/!#|*|#!/!#|*|#!/!#|*|#!/!#|*|#!/");
			System.out.println();
		}//ending bracket of  for loop
	}//ending bracket of main method
	
}//ending bracket of Main Class
