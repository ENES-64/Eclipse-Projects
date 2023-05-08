package exceptionhandling01_trycatch;

public class ExceptionHandling01_TryCatch {
	public static void main(String[] args) {
		int nums[] = {20, 15, 10, 5, 0};
		//Unchecked exceptions are not required to have a try-catch block.
		//But checked exceptions are required to have a try-catch block.
		try {
			int c = nums[0] / nums[1];
			System.out.println("Division is: " + c);
			System.out.println(nums[10]);
		//A super class of exception must be after the sub class of exception.
		//ArithmeticException class is a sub-class of Exception.
		}catch(ArithmeticException e) {
			System.out.println("Denominator can't be zero. Try again.");
		//ArrayIndexOutOfBoundsException is a sub-class of Exception.
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is invalid");
		//Exception class is a super class, so it's the last one.
		}catch(Exception e) {
			System.out.println("Unknown error: " + e);
		}
		System.out.println("End");
	}
}