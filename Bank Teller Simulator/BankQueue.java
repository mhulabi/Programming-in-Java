package com.mohi.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankQueue {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int numberOfTellers;
        int maxCustomers;
        int toMax = 1;
        int priority;
        int turn = 1;
        Customer customer;
        
        System.out.println("What is the number of available tellers at the bank?");
        numberOfTellers = Integer.valueOf(input.next());
        System.out.println("What is the number of maximum customers allowed into the bank per day?");
        maxCustomers = Integer.valueOf(input.next());
        input.close();
        
        ArrayList<Teller> tellerBuffer = new ArrayList<Teller>(numberOfTellers); //Tellers serving the customers
        Queue<Customer> waitingCustomers = new LinkedList<>(); //Customers with waiting numbers
        PriorityQueue<Integer> potentialCustomers = new PriorityQueue<Integer>(); //Customers that want to get waiting numbers 
        //1 for VIP | 2 for Regular
        
        //Initializing Tellers
        for (int i = 0; i < numberOfTellers; i++) {
        	Teller t = new Teller(i + 1);
        	tellerBuffer.add(t);
        }

        while (toMax != maxCustomers + 1) {
        	//To make entry of customers gradual
        	try {
				TimeUnit.SECONDS.sleep(toMax % 3);
			} catch (InterruptedException e) {
				System.out.println("Error in wait! Program Terminated!");
				System.exit(0);
			}
        	if (toMax % 4 == 0) {
	     		potentialCustomers.add(1);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a VIP!");
	 			potentialCustomers.add(2);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a Regular!");
	     	}
        	else if (toMax % 3 == 0) {
        		potentialCustomers.add(1);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a VIP!");
	 			potentialCustomers.add(1);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a VIP!");
        	}
	     	else {
	     		potentialCustomers.add(2);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a Regular!");
	 			potentialCustomers.add(2);
	     		System.out.println("A customer has arrived!");
	 			System.out.println("This customer is a Regular!");
	     	}
	 		
	 		toMax += 2;
        	
        	//Adding to waiting customers since they receive a number here
        	while (waitingCustomers.size() < numberOfTellers*3 && !potentialCustomers.isEmpty()) {
        		priority = potentialCustomers.poll();
        		if (priority == 1) {
        			Customer c = new Customer("VIP");
        			c.setTurn(turn);
        			System.out.println("The most recent " + c.getType() + " customer has recieved turn " + c.getTurn() + " !");
        			System.out.println("There are " + waitingCustomers.size() + " customers ahead of them");
        			turn++;
        			waitingCustomers.add(c);
        		}
        		else {
        			Customer c = new Customer("Regular");
        			c.setTurn(turn);
        			System.out.println("The most recent " + c.getType() + " customer has recieved turn " + c.getTurn() + " !");
        			System.out.println("There are " + waitingCustomers.size() + " customers ahead of them");
        			turn++;
        			waitingCustomers.add(c);
        		}
        	}
        	
        	//Adding to Teller Buffer if there is a free Teller
        	for(int i = 0; i < numberOfTellers; i++) {
        		if(tellerBuffer.get(i).getFree()) {
        			if (!waitingCustomers.isEmpty()) {
        				customer = waitingCustomers.poll();
        				tellerBuffer.get(i).setCurrentCustomer(customer);
        				tellerBuffer.get(i).setFree(false);
        				Thread t = new Thread(tellerBuffer.get(i));
        				t.start();
        			}
        		}
        	}
        	
        }
        
        System.out.println("Maximum capacity of " + maxCustomers + " has been reached for the day no more potential customers will be allowed in line for a number!");
        
        while (potentialCustomers.size() > 0 || waitingCustomers.size() > 0) {
        	
        	//Adding to waiting customers since they receive a number here
        	while (waitingCustomers.size() < numberOfTellers*3 && !potentialCustomers.isEmpty()) {
        		priority = potentialCustomers.poll();
        		if (priority == 1) {
        			Customer c = new Customer("VIP");
        			c.setTurn(turn);
        			System.out.println("The most recent " + c.getType() + " customer has recieved turn " + c.getTurn() + " !");
        			System.out.println("There are " + waitingCustomers.size() + " customers ahead of them");
        			turn++;
        			waitingCustomers.add(c);
        		}
        		else {
        			Customer c = new Customer("Regular");
        			c.setTurn(turn);
        			System.out.println("The most recent " + c.getType() + " customer has recieved turn " + c.getTurn() + " !");
        			System.out.println("There are " + waitingCustomers.size() + " customers ahead of them");
        			turn++;
        			waitingCustomers.add(c);
        		}
        	}
        	
        	//Adding to Teller Buffer if there is a free Teller
        	for(int i = 0; i < numberOfTellers; i++) {
        		if(tellerBuffer.get(i).getFree() == true) {
        			if (!waitingCustomers.isEmpty()) {
        				customer = waitingCustomers.poll();
        				tellerBuffer.get(i).setCurrentCustomer(customer);
        				tellerBuffer.get(i).setFree(false);
        				Thread t = new Thread(tellerBuffer.get(i));
        				t.start();
        			}
        		}
        	}
        }
        
	}
}
