package com.mohi.sj;

public class Player {
	
	private String name;
	private boolean serve;
	private int parPoints = 0;
	private int hihoPoints = 0;
	private int parWins = 0;
	private int hihoWins = 0;
	
	public Player(String name){
		this.name = name;
		this.serve = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setServe(boolean choice){
		this.serve = choice;
	}
	
	public boolean getServe() {
		return this.serve;
	}
	
	public int getParPoints() {
		return this.parPoints;
	}
	
	public int getHihoPoints() {
		return this.hihoPoints;
	}
	
	public int getParWins() {
		return this.parWins;
	}
	
	public int getHihoWins() {
		return this.hihoWins;
	}
	
	public void addPar() {
		this.parPoints += 1;
	}
	
	public void addHiho() {
		this.hihoPoints += 1;
	}
	
	public void resetParPoints() {
		this.parPoints = 0;
	}
	
	public void resetHihoPoints() {
		this.hihoPoints = 0;
	}
	
	public void parWon() {
		this.parWins += 1;
	}
	
	public void hihoWon() {
		this.hihoWins += 1;
	}
	
};
