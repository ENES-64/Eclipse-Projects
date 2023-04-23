package methods;
import java.util.Scanner;

public class Methods {
	//The life of the data is the life of the method, unless it's static.
	//x and y are former parameters.
	int max(int x, int y) {
		if(x>y)
			return x;
		else
			return y;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int a = sc.nextInt(), b = sc.nextInt();
		//Creating an object of this class in order to call a non static method.
		Methods md =new Methods();
		//a and b parameters that are passed to the max method are actual parameters.
		System.out.println("The bigger number is: " + md.max(a, b));
	}
}