package com.mohi.bank;

import java.security.SecureRandom;

public class Teller implements Runnable{
	
	private SecureRandom generator = new SecureRandom();
	private int threadNumber;
	private int sleepTime;
	private boolean isFree;
	Customer currentCustomer;

	public Teller(int threadNumber){
		this.setThreadNumber(threadNumber);
		setFree(true);
	}

	@Override
	public void run() {
		sleepTime = generator.nextInt(5000);
		//setFree(false); //Potential Problem
		try {
			System.out.println("It is now customer "+this.getCurrentCustomer().getTurn()+"'s turn to be served by Teller " + this.getThreadNumber() + " !");
			Thread.sleep(sleepTime);
			System.out.println("Teller " + this.getThreadNumber() + " has finished serving their current customer and is now free!");
		}
		catch (InterruptedException exception){
			System.out.println("Thread " + threadNumber + " has faced an error!");
			Thread.currentThread().interrupt();
		}
		this.setFree(true);
		//System.out.println("Teller " + this.getThreadNumber() + " has finished serving their current customer and is now free!");
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public void setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	public boolean getFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

}
