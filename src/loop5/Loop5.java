package loop5;

import java.util.Scanner;

public class Loop5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Spell out the numbers in words.
		System.out.println("Enter a number: ");
		int num = sc.nextInt(), reverse = 0;
		num = num * 10 + 1;
		while(num>0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		System.out.print("The given number in words:");
		while(reverse>1) {
			switch(reverse%10) {
				case 0: System.out.print(" zero"); break;
				case 1: System.out.print(" one"); break;
				case 2: System.out.print(" two"); break;
				case 3: System.out.print(" three"); break;
				case 4: System.out.print(" four"); break;
				case 5: System.out.print(" five"); break;
				case 6: System.out.print(" six"); break;
				case 7: System.out.print(" seven"); break;
				case 8: System.out.print(" eight"); break;
				default: System.out.print(" nine");
			}
			reverse /= 10;
		}
		System.out.print(".");
	}
}
