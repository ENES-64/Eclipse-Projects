package loop4;

import java.util.Scanner;

public class Loop4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		long sum = 0, num = sc.nextLong(), temp = num;
		while(temp>0) {
			sum += 	Math.pow(temp % 10, 3);
			temp /= 10;
		}
		if(num==sum)	
			System.out.println("The given number is armstrong.");
		else
			System.out.println("The given number is not armstrong.");
	}
}
