package edu.mtc.egr283.project02;

public class Player {

	private String name;
	private int wins;
	private int losses;
	private int space=0;
	private int howManySkipNextTurns=0;
	private boolean hasWonThisGame=false;
	
	public Player(String newName) {
		this(newName, 0);
	}// Ending bracket of constructor
	
	public Player(String newName, int location) {
		this.setName(newName);
		this.setWins(0);
		this.setLosses(0);
		this.setSpace(location);
	}// Ending bracket of constructor
	
	public void startNewGame() {
		hasWonThisGame=false;
		howManySkipNextTurns=0;
		space=0;
	}// Ending bracket of method startNewGame
	public void startNewtournament() {
		hasWonThisGame=false;
		howManySkipNextTurns=0;
		space=0;
		losses=0;
		wins=0;
	}// Ending bracket of method startNewTournament
	
	public boolean getHasWonYet() {
		return this.hasWonThisGame;
	}// Ending bracket of method getHasWonYet

	public void setHasWonYet(boolean setBoolean) {
		this.hasWonThisGame=setBoolean;
	}// Ending bracket of method setHasWonYet
	
	public void setSpace(int newSpace) {
		this.space=newSpace;	
	}// Ending bracket of method setSpace
	
	public int getSpace() {
		return this.space;
	}// Ending bracket of method getSpace
	
	public void addSpaces(int addSpace) {
		this.setSpace(addSpace+this.getSpace());	
	}// Ending bracket of method addaspace
	
	public void removeASkip() {
		this.setSkip(this.getSkips()-1);
	}// Ending bracket of method removeASkip
	
	public void addSkips(int skipNumber) {
		this.setSkip(skipNumber+this.getSkips());
	}// Ending bracket of method addASkip
	
	public void setSkip(int newSkipNumber) {
		this.howManySkipNextTurns=newSkipNumber;
	}// Ending bracket of method setSkip
	
	public int getSkips() {
		return this.howManySkipNextTurns;
	}// Ending bracket of method getSkips

	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	public String getName() {
		return this.name;
	}// Ending bracket of method getName

	private void setWins(int newNumberOfWins) {
		this.wins = newNumberOfWins;
	}// Ending bracket of method setwins
		
	public void addAWin() {
		this.setWins(this.getWins()+1);
	}// Ending bracket of method addAWin
	
	public int getWins() {
		return this.wins;
	}// Ending bracket of method getwins
		
	private void setLosses(int newNumberOfLosses) {
		this.losses = newNumberOfLosses;
	}// Ending bracket of method setLosses
		
	public void addALoss() {
		this.setLosses(this.getLosses()+1);
	}// Ending bracket of method addALoss
	
	public int getLosses() {
		return this.losses;
	}// Ending bracket of method getLosses


}
