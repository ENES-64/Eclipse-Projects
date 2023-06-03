package personal02blackjack;

import java.util.Random;
import java.util.Scanner;

//This program simulates a blackjack game.
//TODO Add win/lose/draw statistics and save it in a text file.
public class Personal02BlackJack {
	//GLOBAL VARIABLES:
	static boolean userHasAce = false;
	static boolean dealerHasAce = false;
	//MAIN:
	public static void main(String[] args) throws InterruptedException {
		Scanner sc =new Scanner(System.in);
		/* 	First row stores all the cards that are pulled: Even index = user, odd index = dealer.
			Card definitions: 2 through 10 are numerics, 1 = ACE, 11 = JACK, 12 = QUEEN, 13 = KING.	
			Second row stores the card's type: 0 = Club (♣), 1 = Diamond (♦), 2 = Hearts (♥), 3 = Spades (♠). */
		//18 is the maximum number of cards that can be pulled in one game between user and dealer.
		int[][] cards =new int[2][18];
		//Counts are initialized to compensate for the 4 cards that are pulled at the beginning.
		int userTotal = 0, dealerTotal = 0, userCount = 2, dealerCount = 3;
		//Pulling the first 2 cards for user and dealer.
		pullCard(cards, 0); pullCard(cards, 1); pullCard(cards, 2); pullCard(cards, 3);
		
		userTotal = getCardValue(cards, 0, 0) + getCardValue(cards, 2, 0);
		dealerTotal = getCardValue(cards, 1, 0) + getCardValue(cards, 3, 0);
		System.out.print("Dealer's hand:" + showCard(cards, 1));
		Thread.sleep(1000);
		//If the user and dealer has 21, it's a push.
		if(userTotal == 21 && dealerTotal == 21) {
			System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nPush.");
			sc.close();
			return;
		//If dealer has 21, dealer wins.
		}else if(dealerTotal == 21) {
			System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nDealer wins.");
			sc.close();
			return;
			//If user has 21, user wins.
		}else if(userTotal == 21) {
			System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nYou win!");
			sc.close();
			return;
		}
		System.out.print("\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2) + "\n");
		
		//User part:
		while(true) {
			System.out.print("Hit or stand? (H/S) ");
			if(sc.next().equalsIgnoreCase("h")) {
				userCount += 2;
				pullCard(cards, userCount);
				userTotal += getCardValue(cards, userCount, userTotal);
				System.out.print(showCard(cards, userCount) + "\n");
				//Turn ACE's value of 11 into 1 if the total exceeds 21.
				if(userTotal > 21 && userHasAce == true) {
					userTotal -= 10;
					userHasAce = false;
				} if(userTotal > 21) {
					break;
				} if(userTotal == 21)
					break;
			} else
				break;
		}
		Thread.sleep(1000);
		//Dealer part:
		System.out.print("Dealer's hand: " + showCard(cards, 1) + showCard(cards, 3));
		Thread.sleep(1000);
		while(true) {
			if(dealerTotal<17) {
				Thread.sleep(1000);
				dealerCount += 2;
				pullCard(cards, dealerCount);
				dealerTotal += getCardValue(cards, dealerCount, dealerTotal);
				System.out.print("\n" + showCard(cards, dealerCount));
				//Turn ACE's value of 11 into 1 if the total exceeds 21.
				if(dealerTotal > 21 && dealerHasAce == true) {
					dealerTotal -= 10;
					dealerHasAce = false;
				} if(dealerTotal > 21)
					break;
				if(dealerTotal == 21)
					break;
			} else
				break;
		}
		//Deciding the winner.
		if(userTotal == dealerTotal) 
			System.out.print("\nPush.");
		else if((userTotal > 21 || dealerTotal > userTotal) && dealerTotal <= 21) 
			System.out.print("\nDealer wins.");
		else if((dealerTotal > 21 || userTotal > dealerTotal) && userTotal <= 21) 
			System.out.print("\nYou win!");
		else
			System.out.print("\nBust.");
		//UNCOMMENT FOR DEBUGGING:
		/*
		System.out.println(); System.out.println();
		for(int i=0;i<16;i++)
			System.out.print(i + ": " +  cards[1][i] + "|" + cards[0][i] + ", ");
		System.out.println("\nuserTotal = " + userTotal + ", dealerTotal = " + dealerTotal);
		*/
		sc.close();
	}
	//METHODS:
	//Pulls a random card and adds it to the array without duplicates.
	static void pullCard(int[][] cards, int index) {
		Random rand = new Random();
		boolean isDuplicate;
		while(true) {
			isDuplicate = false;
			cards[0][index] = rand.nextInt(12)+1;
			cards[1][index] = rand.nextInt(3);
			if(index != 0)
				for(int i=0;i<index;i++)
					if((cards[0][i] == cards[0][index]) && (cards[1][i] == cards[1][index]))
						isDuplicate = true;
			if(isDuplicate==false)
				break;
		}
	}
	//Display the card and its type.
	static String showCard(int[][] cards, int index) {
		char[][] cardType = {{'C', 'D', 'H', 'S'}, {'?', 'a', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'j', 'q', 'k'}};
		return " " + cardType[0][cards[1][index]] + cardType[1][cards[0][index]];
	}
	//Gets the value of a card.
	/* 	Example:
		 - QUEEN is identified as 12, but it's numeric value is 10.
		 - ACE's numeric value is 11 unless the total exceeds 21, in which its numeric value becomes 1.	*/
	static int getCardValue(int[][] cards, int index, int previousTotal) {
		if(cards[0][index]>=2 && cards[0][index]<=10)
			return cards[0][index];
		if(cards[0][index]>10)
			return 10;
		if(previousTotal<=10) {
			if(index %2 == 0)
				userHasAce = true;
			else
				dealerHasAce = true;
			return 11;
		}
		return 1;
	}
}