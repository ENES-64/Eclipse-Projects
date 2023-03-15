package boringmath;

import java.util.Scanner;

public class BoringMath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 3 values:");
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		
		float r1 = (float) (-b + Math.sqrt(b * b - 4f * a * c)) / (2f * a);
		float r2 = (float) (-b - Math.sqrt(b * b - 4f * a * c)) / (2f * a);
		
		System.out.println("r1 and r2 is: " + r1 + ", " + r2);
	}
}
