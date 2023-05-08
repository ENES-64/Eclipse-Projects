package exceptionhandling02_nestedcatch;

public class ExceptionHandling02_NestedCatch {
	public static void main(String[] args) {
		int nums[] = {20, 15, 10, 5, 0};
		
		try {
			int c = nums[0] / nums[1];
			System.out.println("Division is: " + c);
			//Try-catch inside a try-catch. Which means it is a nested catch.
			try {
				System.out.println(nums[10]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}catch(ArithmeticException e) {
			System.out.println("Denominator can't be zero. Try again.");
		}
		System.out.println("End");
	}
}