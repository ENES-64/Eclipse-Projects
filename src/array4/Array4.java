package array4;
import java.util.Arrays;
import java.util.Scanner;

public class Array4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums[]=new int[10], count = 1;
		for(int i=0;i<nums.length - 1;i++) {
			nums[i] = count;
			count++;
		}
		System.out.println("Nums:  " + Arrays.toString(nums));
		//Insert an element into the array.
		System.out.println("Choose an index and a number to insert(1-10): ");
		int index = sc.nextInt() - 1, num = sc.nextInt();
		for(int i=nums.length - 1;i>index;i--)
			nums[i] = nums[i-1];
		
		nums[index] = num;
		System.out.println("Nums:  " + Arrays.toString(nums));
		//Delete an element from the array.
		System.out.println("Choose an index of a number to delete(1-10: ");
		index = sc.nextInt() - 1;
		for(int i=index;i<nums.length - 1;i++)
			nums[i] = nums[i+1];
		nums[nums.length - 1] = 0;
		System.out.println("Nums:  " + Arrays.toString(nums));
	}
}
