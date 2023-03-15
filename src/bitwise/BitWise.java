package bitwise;

import java.util.Scanner;

public class BitWise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 2 numbers for bitwise operation:");
		
		int num = sc.nextInt();
		int num2 = sc.nextInt();

		int bitWiseAND = num & num2;
		int bitWiseOR = num | num2;
		int bitWiseXOR = num ^ num2;
		int bitWiseLEFTSHIFT = num << num2;
		int bitWiseRIGHTSHIFT = num >> num2;
		int bitWiseUNASSIGNEDRIGHTSHIFT = num >>> num2;
		int bitWiseNOT_NUM = ~num;
		int bitWiseNOT_NUM2 = ~num2;
		
		System.out.println("All bitwise operations:");
		System.out.println("Binary of the first number: " + String.format("%s", Integer.toBinaryString(num)));
		System.out.println("Binary of the second number: " + String.format("%s", Integer.toBinaryString(num2)));
		System.out.println("\nAND: " + bitWiseAND + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseAND)));
		System.out.println("\nOR: " + bitWiseOR + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseOR)));
		System.out.println("\nXOR: " + bitWiseXOR + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseXOR)));
		System.out.println("\nLEFT SHIFT: " + bitWiseLEFTSHIFT + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseLEFTSHIFT)));
		System.out.println("\nRIGHT SHIFT: " + bitWiseRIGHTSHIFT + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseRIGHTSHIFT)));
		System.out.println("\nUNASSIGNED RIGHT SHIFT: " + bitWiseUNASSIGNEDRIGHTSHIFT + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseUNASSIGNEDRIGHTSHIFT)));
		System.out.println("\nNOT for the first number: " + bitWiseNOT_NUM + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseNOT_NUM)));
		System.out.println("\nNOT for the second number: " + bitWiseNOT_NUM2 + ".\nBinary: " + String.format("%s", Integer.toBinaryString(bitWiseNOT_NUM2)));
	}
}