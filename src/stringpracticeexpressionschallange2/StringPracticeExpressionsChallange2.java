package stringpracticeexpressionschallange2;

import java.util.Scanner;

public class StringPracticeExpressionsChallange2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String str = sc.next();
		if(str.matches("[01]*")==true)
			System.out.println("You entered a binary number.");
		else if(str.matches("[0-7]*")==true)
			System.out.println("You entered an octal number.");
		else if(str.matches("[0-9]*")==true)
			System.out.println("You entered a decimel number.");
		else if(str.matches("[A-Fa-f0-9]*")==true)
			System.out.println("You entered a hexadecimal number.");
		else if(str.matches("[0][0]/[0-9][0-9]/\\d*")==true)
			System.out.println("You entered an invalid number.");
		else if(str.matches("[0-9][0-9]/[0][0]/\\d*")==true)
			System.out.println("You entered an invalid number.");
		else if(str.matches("[0-1][0-2]/[0-3][0-1]/\\d*")==true)
			System.out.println("You entered a date.");
		else if(str.matches("[1][3-9]/[0-3][0-9]/\\d*")==true)
			System.out.println("You entered an invalid number.");
		else if(str.matches("[0-1][0-9]/[3][2-9]/\\d*")==true)
			System.out.println("You entered an invalid number.");
		else if(str.matches("[0-1][0-9]/[0-3][0-9]/\\d*")==true)
			System.out.println("You entered a date.");
		else
			System.out.println("You entered an invalid number.");
	}
}