package array8;
import java.util.Arrays;

public class Array8 {
	public static void main(String[] args) {
		int[][] nums = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
		int[][] nums2 = {{15, 25, 35}, {45, 55, 65}, {75, 85, 95}};
		System.out.println("    Nums:          Nums2:");
		for(int i=0;i<nums.length;i++) {
			System.out.print(Arrays.toString(nums[i]) + " - ");
			System.out.print(Arrays.toString(nums2[i]) + '\n');
		}
		//Adding 2 matrices.
		int[][] nums3 =new int [nums.length][nums[0].length];
		for(int i=0;i<nums3.length;i++)
			for(int j=0;j<nums3[0].length;j++)
				nums3[i][j] = nums[i][j] + nums2[i][j];
		System.out.println("\nAddition of the two:");
		for(int i=0;i<nums3.length;i++)
			System.out.print(Arrays.toString(nums3[i]) + '\n');
		
		int[][] nums4 = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
		int[][] nums5 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		System.out.println("\n    Nums4:       Nums5:");
		for(int i=0;i<nums.length;i++) {
			System.out.print(Arrays.toString(nums4[i]) + " - ");
			System.out.print(Arrays.toString(nums5[i]) + '\n');
		}
		//Multiplying 2 matrices.
		int[][] nums6 =new int [nums.length][nums[0].length];
		for(int i=0;i<nums.length;i++)
			for(int j=0;j<nums.length;j++)
				for(int k=0;k<nums.length;k++)
					nums6[i][j] += nums4[i][k] * nums5[k][j];
		System.out.println("\nMultiplication of the two:");
		for(int i=0;i<nums6.length;i++)
			System.out.print(Arrays.toString(nums6[i]) + '\n');
		
		//Sorting a string array by alphabetic order.
		String str[] = {"java", "python", "pascal", "smalltalk", "ada", "basic"};
		System.out.println("\nstr: " + Arrays.toString(str));
		java.util.Arrays.sort(str);
		System.out.println("sorted str: " + Arrays.toString(str));
	}
}