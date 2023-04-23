package loop3;

import java.util.Scanner;

public class Loop3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		long num = sc.nextLong();
		if(num<0)
			num *= -1;
		int digit = 0;
		while(num>0) {
			digit++;
			num /= 10;
		}
		if(digit<=1)
			System.out.println("The given number has 1 digit.");
		else
			System.out.println("The given number has " + digit + " digits.");
	}
}