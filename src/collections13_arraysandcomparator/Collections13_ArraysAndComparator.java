package collections13_arraysandcomparator;

import java.util.*;
//Custom comparator:
class CustomComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i, Integer i2) {
		if(i<i2)
			return 1;
		if(i>i2)
			return -1;
		return 0;
	}
}
public class Collections13_ArraysAndComparator {
	public static void main(String [] args) {
		int a[] = {2,4,6,8,1,3,5,7};
		int b[] = {2,4,6,8,1,3,5,7};
		//Comparing the numbers of the two arrays.
		System.out.println("Comparing the two arrays: " + Arrays.compare(a, b));
		System.out.println("Unsorted:");
		for(int x : a)
			System.out.print(x + " ");
		System.out.println();
		//Sorting the numbers of an array.
		Arrays.sort(b);
		System.out.println("Sorted:");
		for(int x : b)
			System.out.print(x + " ");
		System.out.println();
		//Returns the index of a given number.
		System.out.println("Binary search of 8: " + Arrays.binarySearch(b, 8));
		//If the array is an object, custom comparator must be used to compare the objects.
		//Taking wrapper class of integer instead of primitive integer:
		Integer x[] = {2,4,6,8,1,3,5,7};
		//Sorting x with a custom comparator that sorts from higher to lower.
		System.out.println("Sorted with a custom comparator:");
		Arrays.sort(x, new CustomComparator());
		for(int y : x)
			System.out.print(y + " ");
	}
}