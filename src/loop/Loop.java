package loop;

import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Multiplication Table:
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				System.out.printf("%4d", (i * j));
			}
			System.out.println();
		}
		//Factorial of a number.
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		long result = 1;
		for(int k=1;k<=num;k++) {
			result *= k;
		}
		System.out.println("Factorial of the number you entered is " + result + '.');
	}
}