package personal02blackjack;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

//This program simulates a blackjack game and saves statistics to a file.
public class Personal02BlackJack {
	//GLOBAL VARIABLES:
	static boolean userHasAce;
	static boolean dealerHasAce;
	//MAIN:
	//Suppressing warnings since the IDE thinks the resources are never closed after the first while loop ends,
	//but it never ends and the program ends while being inside the first while loop and 
	//the resources are closed before that.
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		while(true) {
			//STATS SYSTEM START:
			TreeMap<Integer, Integer> stats =new TreeMap<>();
			//This must be updated if the location changes.
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
				} catch (IOException e2) { System.out.println(e2); }
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
				Second row stores the card's type: 0 = Club (♣), 1 = Diamond (♦), 2 = Hearts (♥), 3 = Spades (♠). 
			
			18 is the maximum number of cards that can be pulled in one game between user and dealer.
			So, 18 is the Magic Number. https://en.wikipedia.org/wiki/Magic_number_(programming)
			Using byte since number of cards in a deck can't exceed 52.	
			Same with the maximum total value of cards and the dealer's must stand value	*/
			final byte MAX_CARDS = 18, MAX_VALUE_BEFORE_BUST = 21, MUST_STAND_ON = 17;
			
			int[][] cards =new int[2][MAX_CARDS];
			//Totals are the total value of the cards added which gets tested against several conditions.
			//Counts are initialized to compensate for the 4 cards that are pulled at the beginning.
			int userTotal = 0, dealerTotal = 0, userCount = 2, dealerCount = 3;
			//Pulling the first 2 cards for user and dealer.
			pullCard(cards, 0); pullCard(cards, 1); pullCard(cards, 2); pullCard(cards, 3);
			userTotal = getCardValue(cards, 0, 0) + getCardValue(cards, 2, 0);
			dealerTotal = getCardValue(cards, 1, 0) + getCardValue(cards, 3, 0);
			System.out.print("Dealer's hand:" + showCard(cards, 1));
			try {Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e); }
			//If the user and dealer has 21, it's a push.
			if(userTotal == MAX_VALUE_BEFORE_BUST && dealerTotal == MAX_VALUE_BEFORE_BUST) {
				System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nPush.");
				statIncrement(stats, 5);
				statIncrement(stats, 6);
				skip = true;
			//If dealer has 21, dealer wins.
			}else if(dealerTotal == MAX_VALUE_BEFORE_BUST) {
				System.out.print(" " + showCard(cards, 3) + "\n\nYour hand:" + showCard(cards, 0) + showCard(cards, 2)  + "\nDealer wins.");
				statIncrement(stats, 4);
				statIncrement(stats, 6);
				skip = true;
				//If user has 21, user wins.
			}else if(userTotal == MAX_VALUE_BEFORE_BUST) {
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
						if(userTotal > MAX_VALUE_BEFORE_BUST && userHasAce == true) {
							userTotal -= 10;
							userHasAce = false;
						} if(userTotal > MAX_VALUE_BEFORE_BUST) {
							break;
						} if(userTotal == MAX_VALUE_BEFORE_BUST)
							break;
					} else
						break;
				}
				try {Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e); }
				//Dealer part:
				System.out.print("Dealer's hand: " + showCard(cards, 1) + showCard(cards, 3));
				try {Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e); }
				while(true) {
					if(dealerTotal < MUST_STAND_ON) {
						try {Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e); }
						dealerCount += 2;
						pullCard(cards, dealerCount);
						dealerTotal += getCardValue(cards, dealerCount, dealerTotal);
						System.out.print("\n" + showCard(cards, dealerCount));
						//Turn ACE's value of 11 into 1 if the total exceeds 21.
						if(dealerTotal > MAX_VALUE_BEFORE_BUST && dealerHasAce == true) {
							dealerTotal -= 10;
							dealerHasAce = false;
						} if(dealerTotal > MAX_VALUE_BEFORE_BUST)
							break;
						if(dealerTotal == MAX_VALUE_BEFORE_BUST)
							break;
					} else
						break;
				}
				//Deciding the winner.
				if((userTotal == dealerTotal) && userTotal <= MAX_VALUE_BEFORE_BUST && dealerTotal <= MAX_VALUE_BEFORE_BUST) {
					System.out.print("\nPush.");
					statIncrement(stats, 2);
					statIncrement(stats, 6);
				} else if(userTotal <= MAX_VALUE_BEFORE_BUST && dealerTotal > userTotal && dealerTotal <= MAX_VALUE_BEFORE_BUST) {
					System.out.print("\nDealer wins.");
					statIncrement(stats, 1);
					statIncrement(stats, 6);
				} else if((dealerTotal > MAX_VALUE_BEFORE_BUST || userTotal > dealerTotal) && userTotal <= MAX_VALUE_BEFORE_BUST) {
					System.out.print("\nYou win!");
					statIncrement(stats, 0);
					statIncrement(stats, 6);
				} else {
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
				System.out.println("Enter the ante price: ");
				double ante;
				while(true) {
					try {
						ante = sc.nextDouble();
						break;
					} catch(Exception e) {
						System.out.println("You can only enter numbers. Try again.");
					}
				}
				//Calculating the potential profit of each statistics.
				double profit[] = {stats.get(0) * ante, stats.get(1) * ante * -1, 0, stats.get(3) * ante * 1.3, 
						stats.get(4) * ante * -1, stats.get(5) * ante * 0.3, 0};
				for(int i=0;i<6;i++) {
					//Calculating the final potential profit.
					profit[6] += profit[i];
					if(stats.get(i)>0) {
						float current = stats.get(i), total = stats.get(6), percentage = (current / total) * 100F;
						System.out.printf("%1$s %2$d ", statNames[i], stats.get(i));
						if(i<3)
							System.out.print("\t");
						System.out.printf("\t%%%1$05.2f\t$%2$+05.2f\n", percentage, profit[i]);
					}
				}
				System.out.printf("%1$s %2$d\t\t$%3$+05.2f", statNames[6], stats.get(6), profit[6]);
			}//Debug stuff.
			if(option.equalsIgnoreCase("d")) {
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
			}//Reset the stats.
			if(option.equalsIgnoreCase("r")) {
				System.out.println("Are you sure you want to reset all the statistics? (Y/N)");
				if(sc.next().equalsIgnoreCase("y"))
					try(FileWriter write = new FileWriter(file, false)) {
						write.write("wins:0;losses:0;draws:0;blackjackwins:0;blackjacklosses:0;blackjackdraws:0;totalhandsplayed:0;\t\t\t\t\t\t");
						System.out.println("All the statistics have been reset.");
					} catch (IOException e) {System.out.println(e);}
			}//Ask the user if they want to continue again.
			if(option.equalsIgnoreCase("c")==false) {
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
	//Loading stats into a TreeMap collection.
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