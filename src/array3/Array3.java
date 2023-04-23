package array3;
import java.util.Arrays;

public class Array3 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//Shift the arrays to left.
		int temp = nums2[0];
		for(int i=1;i<nums2.length;i++) {
			nums2[i-1] = nums2[i];
			if(i==nums2.length - 1)
				nums2[nums2.length - 1] = temp;
		}

		//Shift the arrays to right.
		temp = nums3[nums3.length - 1];
		for(int i=nums3.length - 2;i>=0;i--) {
			nums3[i+1] = nums3[i];
			if(i==0)
				nums3[0] = temp;
		}
		System.out.println("Nums:  " + Arrays.toString(nums));
		System.out.println("Nums2: " + Arrays.toString(nums2));
		System.out.println("Nums3: " + Arrays.toString(nums3));
	}
}