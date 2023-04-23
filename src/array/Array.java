package array;

public class Array {
	public static void main(String[] args) {

		int A[]=new int[5];

		int B[]= {1,2,3,4,5};

		int C[];
		C =new int[5];
		
		int[] D =new int[5];
		
		int[] array = {2,4,6,8,10};
		//Traverse
		for(int i = 0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		//Reverse traverse
		for(int i = array.length-1; i>=0 ; i--)
			System.out.print(array[i] + " ");
		System.out.println();
		//Traverse using for each loop
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
}