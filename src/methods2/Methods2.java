package methods2;
import java.util.Arrays;

public class Methods2 {
	//When primitive variables are passed, they are copied to the method.
	//When an object is passed to the method, the reference is copied. Not the object.
	//So, both nums and x are referring to the same object.
	//Any changes from the two references will affect the same object.
	static void update(int x[], int y) {
		x[0] = 5;
		y = 50;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int num = 10;
		System.out.println("Nums:  " + Arrays.toString(nums));
		System.out.println("Num: " + num);
		update(nums, num);
		System.out.println("\nNums:  " + Arrays.toString(nums));
		System.out.println("Num: " + num);
	}
}