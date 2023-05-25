package com.mohi.sj;
import java.security.SecureRandom;
import java.util.Scanner;

public class SquashJudge {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		SecureRandom random = new SecureRandom(); //For random mode
		
		String player1;
		String player2;
		String wPrint = "W";
		String lPrint = "L";
		char mode;
		String winner;

		int randNum;
		int round = 1;
		int game = 1;
		boolean parGame = false;
		boolean hihoGame = false;
		boolean parFinish = false;
		boolean hihoFinish = false;
		
		System.out.println("Enter name of Player 1: ");
		player1 = input.next();
		Player p1 = new Player (player1);
		
		System.out.println("Enter name of Player 2: ");
		player2 = input.next();
		Player p2 = new Player (player2);
		
		System.out.println("Manual (M) or Random (R): ");
		mode = input.next().charAt(0);
		
		if (mode != 'R' || mode != 'M') {
			System.out.println("Invalid mode has been selected, as default R has been selected!");
			mode = 'R';
		}
		
		if (mode == 'R') {
			System.out.println("Game #		Round #		" + player1 + "		" + player2);
		}
		
		while(!parFinish || !hihoFinish){
			
			//randomly assigning first serve of each game and printing it
			randNum = random.nextInt() % 2;
			if (randNum == 0) {
				System.out.println("SERVE " + p1.getName());
				p1.setServe(true);
				p2.setServe(false);

			}
			else {
				System.out.println("SERVE " + p2.getName());
				p2.setServe(true);
				p1.setServe(false);

			}
			
			while (parGame == false || hihoGame == false) {
				if (mode == 'M') {
					System.out.println( "Game " + game +": Please select the winner of round " + round);
					System.out.println( player1 + " or " + player2);
					winner = input.next();
					if (p1.getName().equals(winner)) {
						if (p1.getServe() && !hihoGame && !hihoFinish) {
							p1.addHiho();
							if (p1.getHihoPoints() == 9) {
								p1.hihoWon();
								hihoGame = true;
								System.out.println("Hiho Game Finished");
								if (p1.getHihoWins() == 3) {
									hihoFinish = true;
								}
								else {
									p1.resetHihoPoints();
									p2.resetHihoPoints();
								}
							}
						}
						if(!parGame && !parFinish) {
						p1.addPar();
						if (p1.getParPoints() >= 11 && (p1.getParPoints() - p2.getParPoints()) >= 2) {
							p1.parWon();
							parGame = true;
							System.out.println("Par Game Finished"); 
							if (p1.getParWins() == 3) {
								parFinish = true;
							}
							else {
								p1.resetParPoints();
								p2.resetParPoints();
							}
						}}
						System.out.println("Game #		Round #		" + player1 + "		" + player2);
						System.out.println(game + "		" + round + "		" + wPrint + "		" + lPrint + "\n");
						p1.setServe(true);
						p2.setServe(false);
						round++;
					}
					else if (p2.getName().equals(winner)) {
						if (p2.getServe() && !hihoGame && !hihoFinish) {
							p2.addHiho();
							if (p2.getHihoPoints() == 9) {
								p2.hihoWon();
								hihoGame = true;
								System.out.println("Hiho Game Finished");
								if (p2.getHihoWins() == 3) {
									hihoFinish = true;
								}
								else {
									p1.resetHihoPoints();
									p2.resetHihoPoints();
								}
							}
						}
						if(!parGame && !parFinish) {
						p2.addPar();
						if (p2.getParPoints() >= 11 && (p2.getParPoints() - p1.getParPoints()) >= 2) {
							p2.parWon();
							parGame = true;
							System.out.println("Par Game Finished");
							if (p2.getParWins() == 3) {
								parFinish = true;
							}
							else {
								p1.resetParPoints();
								p2.resetParPoints();
							}
						}}
						System.out.println("Game #		Round #		" + player1 + "		" + player2);
						System.out.println(game + "		" + round + "		" + lPrint + "		" + wPrint + "\n");
						p2.setServe(true);
						p1.setServe(false);
						round++;
					}
					else {System.out.println("An incorrect Player Name has been chosen, please try again!");}
				}
				
				else if (mode == 'R') {
					randNum = random.nextInt() % 2;
					switch(randNum) {
						case 0:
							if (p1.getServe() && !hihoGame && !hihoFinish) {
								p1.addHiho();
								if (p1.getHihoPoints() == 9) {
									p1.hihoWon();
									hihoGame = true;
									if (p1.getHihoWins() == 3) {
										hihoFinish = true;
									}
									else {
										p1.resetHihoPoints();
										p2.resetHihoPoints();
									}
								}
							}
							if (!parGame && !parFinish) {
							p1.addPar();
							if (p1.getParPoints() >= 11 && (p1.getParPoints() - p2.getParPoints()) >= 2) {
								p1.parWon();
								parGame = true;
								if (p1.getParWins() == 3) {
									parFinish = true;
								}
								else {
									p1.resetParPoints();
									p2.resetParPoints();
								}
							}}
							System.out.println(game + "		" + round + "		" + wPrint + "		" + lPrint);
							p1.setServe(true);
							p2.setServe(false);
							round++;
							break;
						case 1:
							if (p2.getServe() && !hihoGame && !hihoFinish) {
								p2.addHiho();
								if (p2.getHihoPoints() == 9) {
									p2.hihoWon();
									hihoGame = true;
									if (p2.getHihoWins() == 3) {
										hihoFinish = true;
									}
									else {
										p1.resetHihoPoints();
										p2.resetHihoPoints();
									}
								}
							}
							if (!parGame && !parFinish) {
							p2.addPar();
							if (p2.getParPoints() >= 11 && (p2.getParPoints() - p1.getParPoints()) >= 2) {
								p2.parWon();
								parGame = true;
								if (p2.getParWins() == 3) {
									parFinish = true;
								}
								else {
									p1.resetParPoints();
									p2.resetParPoints();
								}
							}}
							System.out.println(game + "		" + round + "		" + lPrint + "		" + wPrint);
							p2.setServe(true);
							p1.setServe(false);
							round++;
							break;
						default:
							break;
					}
				}
			}
			game++;
			round = 1;
			parGame = false;
			hihoGame = false;
			
			if (p1.getParWins() == 3){
				parFinish = true;
				parGame = true;
			}
			else if (p2.getParWins() == 3){
				parFinish = true;
				parGame = true;
			}
			
			if (p1.getHihoWins() == 3){
				hihoFinish = true;
				hihoGame = true;
			}
			else if (p2.getHihoWins() == 3){
				hihoFinish = true;
				hihoGame = true;
			}
			
		}
		if (p1.getParWins() == 3) {
			System.out.println( "According to PAR Judge " + p1.getName() + " won the match with " + p1.getParWins() + "-" + p2.getParWins() );} //PAR Score
		else {			
			System.out.println( "According to PAR Judge " + p2.getName() + " won the match with " + p1.getParWins() + "-" + p2.getParWins() );} //PAR Score
		if(p1.getHihoWins() == 3) {
			System.out.println( "According to HIHO Judge " + p1.getName() + " won the match with " + p1.getHihoWins() + "-" + p2.getHihoWins() );} //HIHO Score
		else {		
			System.out.println( "According to HIHO Judge " + p2.getName() + " won the match with " + p1.getHihoWins() + "-" + p2.getHihoWins() );} //HIHO Score
		
		input.close();
	}
	
}
