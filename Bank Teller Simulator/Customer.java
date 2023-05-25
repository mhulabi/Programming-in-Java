package com.mohi.bank;

public class Customer {
	
	private int turn;
	private String type;
	
	public Customer(String type) {
		this.type = type;
	}
	
	void setTurn(int number) {
		this.turn = number;
	}
	
	int getTurn() {
		return turn;
	}
	
	void setType(String type) {
		this.type = type;
	}
	
	String getType() {
		return type;
	}
	
}
