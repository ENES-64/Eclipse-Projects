package array2;

import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};
		//Finding the sum of the elements in the array.
		int sum = 0;
		for(int x : array) {
			sum += x;
			System.out.print(x + " ");
		}
		System.out.println("\nSum of this array is: " + sum + ".\n");
		//Finding the index of an element in the array.
		System.out.println("Enter one of the numbers from array to find its index:");
		int num = sc.nextInt();
		int key = 0;
		for(int x : array) {
			if(x!=num)
				key++;
			else
				break;
		}
		if(key==array.length)
			System.out.println(num + " is not found.");
		else
			System.out.println(num + " is located at index " + key + ".\n");
		//Finding the second largest element in the array.
		int max = 0;
		int secondmax = 0;
		for(int x : array) {
			if(x>max) {
				secondmax = max;
				max = x;
			}
		}
		System.out.println("Second largest number in the array is: " + secondmax);
	}
}