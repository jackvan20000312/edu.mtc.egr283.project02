package edu.mtc.egr283.project02;

import javax.swing.JOptionPane;


public class Test {
	static RedDeck yellowdeck=new RedDeck();
	static YellowDeck reddeck=new YellowDeck();
	private static int PLAYER_NUMBER=4;
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null,"If you press cancel at any stage of this Program, It will quit playing.", "Task Failed Succesfully", JOptionPane.ERROR_MESSAGE);
		int onegameOrNot = JOptionPane.showConfirmDialog(null, "Would you Like To Play 1 game?");
		if (onegameOrNot==0) {
			int variableUsersOrNot = JOptionPane.showConfirmDialog(null, "Would you Like To Play with more or less users?");
			if (variableUsersOrNot==0) {
				int playerNumber=Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of players"));
				boolean rv = false;
				Player[] player = new Player[playerNumber];
				for(int i = 0; i<playerNumber; i++) {
					player[i]=new Player("Player #"+(i+1));
				}
				for(int i=0; i<playerNumber; i++) {
					player[i].startNewGame();
				}
				do {
					for(int i=0; i<playerNumber; i++) {
						System.out.println(PickACard.start(player[i], reddeck, yellowdeck));
						System.out.println();
						if(player[i].getHasWonYet()) {
							rv=true;
							break;
						}
					}
				}while(!rv);
			}else if(variableUsersOrNot==1) {
				boolean rv = false;
				Player[] player = new Player[PLAYER_NUMBER];
				for(int i = 0; i<PLAYER_NUMBER; i++) {
					player[i]=new Player("Player #"+(i+1));
				}
				for(int i=0; i<PLAYER_NUMBER; i++) {
					player[i].startNewGame();
				}
				do {
					for(int i=0; i<PLAYER_NUMBER; i++) {
						System.out.println(PickACard.start(player[i], reddeck, yellowdeck));
						System.out.println();
						if(player[i].getHasWonYet()) {
							rv=true;
							break;
						}
					}
				}while(!rv);
			}else {
				System.exit(0);
			}
		}else if(onegameOrNot==1) {
			int variableUsersOrNot = JOptionPane.showConfirmDialog(null, "Would you Like To Play with more or less users?");
			if (variableUsersOrNot==0) {
				int playerNumber=Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of players"));
				Player[] player = new Player[playerNumber];
				for(int i = 0; i<playerNumber; i++) {
					player[i]=new Player("Player #"+(i+1));
				}
				
				for(int j=0; j<10; j++) {
					boolean rv = false;
					for(int i=0; i<playerNumber; i++) {
						player[i].startNewGame();
					}
					do {
						for(int i=0; i<playerNumber; i++) {
							System.out.println(PickACard.start(player[i], reddeck, yellowdeck));
							System.out.println();
							if(player[i].getHasWonYet()) {
								rv=true;
								break;
							}
						}
					}while(!rv);
					System.out.println("Game #"+(j+1)+" just ended!!!");
				}
				for(int i=0; i<playerNumber; i++) {
					System.out.println(player[i].getName()+"Won "+player[i].getWins()+" times");
				}		
			}else if(variableUsersOrNot==1) {
				Player[] player = new Player[PLAYER_NUMBER];
				for(int i = 0; i<PLAYER_NUMBER; i++) {
					player[i]=new Player("Player #"+(i+1));
				}
				
				for(int j=0; j<10; j++) {
					boolean rv = false;
					for(int i=0; i<PLAYER_NUMBER; i++) {
						player[i].startNewGame();
					}
					do {
						for(int i=0; i<PLAYER_NUMBER; i++) {
							System.out.println(PickACard.start(player[i], reddeck, yellowdeck));
							System.out.println();
							if(player[i].getHasWonYet()) {
								rv=true;
								break;
							}
						}
					}while(!rv);
					System.out.println("Game #"+(j+1)+" just ended!!!");
				}
				for(int i=0; i<PLAYER_NUMBER; i++) {
					System.out.println(player[i].getName()+"Won "+player[i].getWins()+" times");
				}
				}else {
					System.exit(0);
				}
		}else {
			System.exit(0);
		}
	}
}
