package personal02blackjack;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

//TODO Calculate the profits/losses using the statistic data file by inputing an ante price.
//This program simulates a blackjack game and saves statistics to a file.
public class Personal02BlackJack {
	//GLOBAL VARIABLES:
	static boolean userHasAce;
	static boolean dealerHasAce;
	//MAIN:
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		while(true) {
			//STATS SYSTEM START:
			TreeMap<Integer, Integer> stats =new TreeMap<>();
			File file = new File("/Users/enesy/MyJava/Eclipse/MyEclipse/src/personal02blackjack/statistics.txt");
			FileInputStream fi = null;
			//Creating an input stream for a scanner to read it.
			try {
				fi = new FileInputStream(file);
			//If the file is not found, write all the stats.
			} catch (FileNotFoundException e) {
				try(FileWriter write = new FileWriter(file, true)) {
					write.write("wins:0;losses:0;draws:0;blackjackwins:0;blackjacklosses:0;blackjackdraws:0;totalhandsplayed:0;");
					fi = new FileInputStream(file);
				} catch (IOException e2) {}
			}
			//Reading the stats from the text file using scanner and saving it to a string as a whole.
			Scanner getStat =new Scanner(fi);
			getStat.useDelimiter("\\Z");
			String settings = null;
			try {
				settings = getStat.next();
			//If the file is found, but it's empty, write all the stats.
			} catch(NoSuchElementException e) {
				try(FileWriter write = new FileWriter(file, true)) {
					write.write("wins:0;losses:0;draws:0;blackjackwins:0;blackjacklosses:0;blackjackdraws:0;totalhandsplayed:0;");
					fi = new FileInputStream(file);
					settings = getStat.next();
				} catch (IOException e2) {}
			}
			//Making sure no word is capitalized and there are no spaces.
			settings = settings.toLowerCase();
			settings = settings.replaceAll("\\s", "");
			//Tokenizing the settings.
			while(true) {
				String temp = settings;
				try {
					temp = temp.substring(0, temp.indexOf(";"));
					setSetting(temp, stats);
					settings = settings.substring(settings.indexOf(";") + 1, settings.length());
					if(settings.indexOf(";")==-1)
						break;
				} catch(Exception e) {}
			}
			//STATS SYSTEM END:
			
			Scanner sc =new Scanner(System.in);
			boolean skip = false;
			userHasAce = false;
			dealerHasAce = false;
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
				statIncrement(stats, 5);
				statIncrement(stats, 6);
				skip = true;
			//If dealer has 21, dealer wins.
			}else if(dealerTotal == 21) {
				System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nDealer wins.");
				statIncrement(stats, 4);
				statIncrement(stats, 6);
				skip = true;
				//If user has 21, user wins.
			}else if(userTotal == 21) {
				System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nYou win!");
				statIncrement(stats, 3);
				statIncrement(stats, 6);
				skip = true;
			}
			if(skip==false) {
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
				if((userTotal == dealerTotal) && userTotal <= 21 && dealerTotal <= 21) {
					System.out.print("\nPush.");
					statIncrement(stats, 2);
					statIncrement(stats, 6);
				}
				else if(userTotal <= 21 && dealerTotal > userTotal && dealerTotal <= 21) {
					System.out.print("\nDealer wins.");
					statIncrement(stats, 1);
					statIncrement(stats, 6);
				}
				else if((dealerTotal > 21 || userTotal > dealerTotal) && userTotal <= 21) {
					System.out.print("\nYou win!");
					statIncrement(stats, 0);
					statIncrement(stats, 6);
				}
				else {
					System.out.print("\nBust.");
					statIncrement(stats, 1);
					statIncrement(stats, 6);
				}
			}
			//Pre-defining stat names.
			String[] statNames = {"Wins:", "Losses:", "Draws:", "Blackjack wins:", "Blackjack losses:", "Blackjack draws:", "Total hands played:"};
			//Saving the updated stats.
			try(FileWriter write = new FileWriter(file, false)) {
				for(int i=0;i<7;i++) {
					String temp = statNames[i].replaceAll("\\s", "");
					temp = temp.toLowerCase();
					temp += stats.get(i) + ";";
					write.write(temp);
				}
			} catch(IOException e) {System.out.println(e);}
			System.out.println("\nType S to view statistics, C to continue, R to reset stats, D to debug.");
			String option = sc.next();
			//Show statistics.
			if(option.equalsIgnoreCase("s")) {
				for(int i=0;i<6;i++)
					if(stats.get(i)>0) {
						float current = stats.get(i), total = stats.get(6), percentage = (current / total) * 100F;
						System.out.printf("%1$s %2$d ", statNames[i], stats.get(i));
						if(i<3)
							System.out.print("	");
						System.out.print("	%");
						System.out.printf("%05.2f\n", percentage);
					}
				System.out.printf("%1$s %2$d ", statNames[6], stats.get(6));
			//Debug stuff.	
			} if(option.equalsIgnoreCase("d")) {
				for(int i=0;i<16;i++)
					System.out.print(i + " " +  cards[1][i] + "|" + cards[0][i] + ", ");
				System.out.println("\nuserTotal = " + userTotal + ", dealerTotal = " + dealerTotal);
				try {
					@SuppressWarnings("unused")
					//The purpose of this variable is that if it gives an exception,
					//it means there were no extra settings.
					boolean exceptionCheck = stats.get(7) == 0;
					System.out.println("There are unknown settings.");
				} catch(NullPointerException e) {
					System.out.println("There are no unknown settings.");
				}
				System.out.println("stats: " + stats);
			//Reset the stats.
			} if(option.equalsIgnoreCase("r")) {
				System.out.println("Are you sure you want to reset all the statistics? (Y/N)");
				if(sc.next().equalsIgnoreCase("y"))
					try(FileWriter write = new FileWriter(file, false)) {
						write.write("wins:0;losses:0;draws:0;blackjackwins:0;blackjacklosses:0;blackjackdraws:0;totalhandsplayed:0;\t\t\t\t\t\t");
						System.out.println("All the statistics have been reset.");
					} catch (IOException e) {System.out.println(e);}
			//Ask the user if they want to continue again.
			} if(option.equalsIgnoreCase("c")==false) {
				System.out.println("\nType C to continue. Anything else to exit.");
				if(sc.next().equalsIgnoreCase("c")==false) {
					//Close everything.
					sc.close();
					getStat.close();
					try { fi.close(); } catch (IOException e) { System.out.println(e); }
					return;
				}
			}
		}
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
	//Loading stats into a TreeMap collection and also Keeping a track on
	//how many settings are present in case some are missing.
	static void setSetting(String setting, TreeMap<Integer, Integer> stats) {
		int stat = Integer.parseInt(setting.substring(setting.indexOf(":") + 1, setting.length()));
		setting = setting.substring(0, setting.indexOf(":"));
		switch(setting) {
			case "wins": stats.put(0, stat); break;
			case "losses": stats.put(1, stat); break;
			case "draws": stats.put(2, stat); break;
			case "blackjackwins": stats.put(3, stat); break;
			case "blackjacklosses": stats.put(4, stat); break;
			case "blackjackdraws": stats.put(5, stat); break;
			case "totalhandsplayed": stats.put(6, stat); break;
			default: stats.put(7, stat);
		}
	}
	//Increments the stat. Index determines which stat to increment.
	//0 = wins, 1 = losses, 2 = draws, 3 = bj wins, 4 = bj losses, 5 = bj draws, 6 = total hands played.
	static void statIncrement(TreeMap<Integer, Integer> stats, int index) {
		int stat = stats.get(index);
		stats.put(index, ++stat);
	}
}