package methods9;
import java.util.Arrays;
import java.util.Scanner;

public class Methods9 {
	int area(int x) {
		int reverse = 0;
		if(x>0) {
			while(x>0) {
				reverse = reverse * 10 + x % 10;
				x /= 10;
			}
		}else
			while(x<0) {
				reverse = reverse * 10 + x % 10;
				x /= 10;
			}
		return reverse;
	}
	int[] area(int x[]) {
		int[] numsReverse =new int[5];
		for(int i = x.length-1, j = 0; i>=0 ; i--, j++)
			numsReverse[j] = x[i];
		return numsReverse;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods9 method =new Methods9();
		int[] nums =new int[5];
		System.out.println("Enter a number: ");
		System.out.println("Reverse of that number: " + method.area(sc.nextInt()));
		System.out.println("Enter 5 numbers in order");
		for(int i=0;i<5;i++)
			nums[i] = sc.nextInt();
		System.out.println("Reverse order of the numbers:\n" + Arrays.toString(method.area(nums)));
	}
}