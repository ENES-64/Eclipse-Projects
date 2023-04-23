package array6;

public class Array6 {
	public static void main(String[] args) {
		//2 dimensional array. First is the row, second is the column.
		int[][] A =new int[3][5];
		//{{<First row>}, {<Second row>}, {<Third row>}}
		int[][] nums = {{1, 2, 3, 4, 5}, {6, 7, 8, 9 ,10}, {11, 12, 13, 14, 15}};
		
		System.out.println("Nums:");
		for(int x[] : nums) {
			for(int y : x)
				System.out.printf("%02d ", y);
			System.out.println();
		}
		System.out.println("\nRows of the array: " + nums.length);
		System.out.println("Columns of the array: " + nums[0].length);
	}
}