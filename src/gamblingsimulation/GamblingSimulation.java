package gamblingsimulation;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GamblingSimulation {
	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Your ID is 0001.\nDeposit money: ");
		float totalBalance = 0.0f, balance = 0.0f, total, max, min, winningNumber;
		String option;
		int playerCount, g = 0, winner = 0;
		String outOfRangeHigh = "Your bet is out of range.";
		String outOfRangeLow = "You don't have enough balance.";
		
		for(int i=1;i>0;i++) {
			totalBalance = sc.nextFloat();
			if(totalBalance<10000.0f)
				System.out.println("You need to deposit at least $10,000.");
			else
				i = -1;
		}
		//9 possible participants.
		float[] percentages = new float[10];
		float[] playerBalances = new float[9];
		int[] ids = new int[10];
		
		//Whole program loops until user types '-1'.
		for(int j=1;j>0;j++) {
			for(int n=0;n<=9;n++) {
				percentages[n] = 0.0f;
				ids[n] = 0;
				if(n!=9)
					playerBalances[n] = 0.0f;
			}
			ids[9] = 1;
			option = null;
			for(int h=1;h>0;h++) {
				System.out.printf("How much do you want to bet(your balance is $%.2f)?", totalBalance);
				System.out.println("\nType -1 to exit.");
				balance = sc.nextFloat();
				if(balance==-1) {
					j = -1;
					h = -1;
				}else {
					if(balance>totalBalance)
						System.out.println("You don't have enough funds.");
					else if(balance<10000)
						System.out.println("You need to at least bet $10,000.");
					else if(balance>5000000)
						System.out.println("You can't bet more than $5,000,000.");
					else
						h = -1;
				}
			}
			if(j!=-1) {
				total = balance;
				System.out.println("Choose an option(L for low[$10,000 - $100,000], H for high[$100,000 - $1,000,000], U for ultra high[$1,000,000 - $5,000,000]):");
				for(int k=1;k>0;k++) {
					option = sc.next();
					if(option.matches("[LHU]|[lhu]?{1}")==false)
						System.out.println("Wrong option entered. Try again.\n(L for low[$10,000 - $100,000], H for high[$100,000 - $1,000,000], U for ultra high[$1,000,000 - $5,000,000])");
					else {
						if(option.equalsIgnoreCase("u")==true && balance < 1000000.0f) 
							System.out.println(outOfRangeLow);
						else if(option.equalsIgnoreCase("h")==true && balance < 100000.0f) 
							System.out.println(outOfRangeLow);
						else if(option.equalsIgnoreCase("u")==true && balance > 5000000.0f)
							System.out.println(outOfRangeHigh);
						else if(option.equalsIgnoreCase("h")==true && balance > 1000000.0f)
							System.out.println(outOfRangeHigh);
						else if(option.equalsIgnoreCase("l")==true && balance > 100000.0f)
							System.out.println(outOfRangeHigh);
						else
							k = -1;
					}
				}
				if(option.equalsIgnoreCase("u")==true) {
					max = 5000000.0f;
					min = 1000000.0f;
				}else if(option.equalsIgnoreCase("h")==true) {
					max = 1000000.0f;
					min = 100000.0f;
				}else {
					max = 100000.0f;
					min = 10000.0f;
				}
				//Assign 9 random IDs and balances.
				for(int l=0;l<9;l++) {
					playerBalances[l] = rand.nextFloat(max-min) + min;
					ids[l] = rand.nextInt(9997) + 2;
					//Make sure there are no duplicate IDs.
					if(l>0) {
						for(int u=0;u<l;u++) {
							if(ids[u]==ids[l])
								l--;
						}
					}
				}
				//Random participants between 4 and 9.
				playerCount = rand.nextInt(5) + 4;
				
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Clear console.
				System.out.print("ID 0001: %100.00 - $");
				System.out.printf("%.2f \n", balance);
				
				//Simulate players joining in.
				for(int i=0;i<playerCount;i++) {
					total += playerBalances[i];
					Thread.sleep(rand.nextInt(2125) + 175);
					//Percentage math = 100/(total/person)
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Clear console.
					System.out.print("ID 0001: %");
					System.out.printf("%05.2f - $%.2f \n", 100/(total/balance)+0.01, balance);
					g = 0;
					for(;g<=i;g++) {
						System.out.printf("ID %04d: ", ids[g]); 
						System.out.print("%");
						System.out.printf("%05.2f - $%.2f \n", 100/(total/playerBalances[g]), playerBalances[g]);
					}
				}
				//Excruciatingly painful math and logic.
				percentages[9] = 100/(total/balance);
				for(int n=0;n<playerCount;n++) {
					percentages[n] = 100/(total/playerBalances[n]);
					if(n>0)
						percentages[n] += percentages[n-1];
					else
						percentages[n] += percentages[n+9];
				}
				//Animation.
				for(int m=0;m<=100;m++) {
					if(m<50)
						Thread.sleep(50);
					else if(m<75)
						Thread.sleep(100);
					else if(m<87)
						Thread.sleep(200);
					else if(m<95)
						Thread.sleep(400);
					else if(m<98)
						Thread.sleep(1000);
					winningNumber = rand.nextFloat(100.0f);
					for(int b=-1;b<9;b++)
						if(b==-1 && winningNumber<percentages[9])
							winner = 9;
						else if(b==0 && winningNumber<percentages[b] && winningNumber>percentages[9])
							winner = b;
						else if(b>0 && winningNumber<percentages[b] && winningNumber>percentages[b-1])
							winner = b;
					if(m%2==0) {
						System.out.print("\r");
						System.out.printf(" | The winner is: %04d", ids[winner]);
					}
					else {
						System.out.print("\r");
						System.out.printf(" O The winner is: %04d", ids[winner]);
					}
				}
				System.out.print('\n');
				if(winner==9) {
					totalBalance += total;
					System.out.printf("You won $%.2f!", total);
					System.out.print('\n');
				}else
					totalBalance -= balance;
			}
		}
	}
}