package array7;

public class Array7 {
	public static void main(String[] args) {
		//Ways to declare arrays:
		int A[][] =new int[5][5];
		
		int B[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int C[][];
		C =new 	int[5][5];
		
		int []D[] =new int[5][5];
		
		int E[], F[];
		E =new int[5]; F =new int[5];
		
		int[]G,H[];
		G =new int [5]; H =new int [5][5];
		
		int[] I, J, K[], L, M[];
		I =new int [5]; J =new int [5]; K =new int [5][5]; L =new int [5]; M =new int [5][5];
		
		int[][] nums;
		//This creates just rows that are references.
		nums =new int[3][];
		//These creates a jagged array with different sizes of columns.
		nums[0] =new int[2];
		nums[1] =new int[4];
		nums[2] =new int[3];
		
		for(int x[] : nums) {
			for(int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}
}