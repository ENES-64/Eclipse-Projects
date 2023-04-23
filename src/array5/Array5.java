package array5;
import java.util.Arrays;

public class Array5 {
	public static void main(String[] args) {
		int[] nums = {1, 2 ,3 ,4 ,5}, nums2 =new int[5];
		//Reverse copying an array to another.
		for(int i=nums.length - 1, j = 0;i>=0;i--, j++) {
			nums2[i] = nums[j];
		}
		System.out.println("Nums:  " + Arrays.toString(nums));
		System.out.println("Nums:  " + Arrays.toString(nums2));
	}
}
