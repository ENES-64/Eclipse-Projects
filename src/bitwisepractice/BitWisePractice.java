package bitwisepractice;

import java.util.Scanner;

public class BitWisePractice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two 4-bit values (0 - 7):");
		byte num = sc.nextByte();
		byte num2 = sc.nextByte();
		
		num = (byte) (num << 4);
		num2 = (byte) (num2 ^ num);
		
		System.out.println("Total is " + num2 + ".\n Binary: " + String.format("%s", Integer.toBinaryString(num2)));
		System.out.println("\nFirst value is " + (num2 >> 4) + ".\n Binary: " + String.format("%s", Integer.toBinaryString(num2 >> 4))); 
		System.out.println("\nSecond value is " + (num2&0b0001111) + ".\n Binary: " + String.format("%s", Integer.toBinaryString(num2&0b0001111)));
	}
}