package methods6;

import java.util.Scanner;

public class Methods6 {
	int max(int[] x) {
		int largest = 0;
		for(int i=0;i<x.length;i++)
			if(x[i]>largest)
				largest = x[i];
		return largest;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods6 method =new Methods6();
		System.out.println("Enter 10 numbers: ");
		int nums[] =new int[10];
		for(int i=0;i<10;i++)
			nums[i] = sc.nextInt();
		System.out.println("Largest number you entered is: " + method.max(nums));
	}
}