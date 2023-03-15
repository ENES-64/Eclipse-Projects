package ifelse;

import java.util.Scanner;

public class IfElse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		int num = sc.nextInt();
		if(num%2 == 0)
			System.out.println("The number is even.");
		else
			System.out.println("The number is odd.");
		
		System.out.println("Enter three scores:");
		int score1 = sc.nextInt(), score2 = sc.nextInt(), score3 = sc.nextInt();
		float average;
		average = 3 / (score1 + score2 + score3);
		if(average>=90)
			System.out.println("Your grade is A.");
		else if(average>=80)
			System.out.println("Your grade is B.");
		else if(average>=70)
			System.out.println("Your grade is C.");
		else if(average>=60)
			System.out.println("Your grade is D.");
		else 
			System.out.println("Your grade is F.");

		System.out.println("Enter your age:");
		int age = sc.nextInt();
		if(age>=14 && age<=55)
			System.out.println("You're young.");
		else if(age<=14 || age>=55)
			System.out.println("You're not young.");
		
		System.out.println("Enter a year:");
		int year = sc.nextInt();
		if(year%4 == 0)
			if(year%100 == 0)
				if(year%400 == 0)
					System.out.println("It is a leap year.");
				else
					System.out.println("It is not a leap year.");
			else
				System.out.println("It is a leap year.");
		else
			System.out.println("It is not a leap year.");
	}
}