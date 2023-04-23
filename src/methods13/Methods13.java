package methods13;

public class Methods13 {
	int sum(int... x) {
		int sum = 0;
		for(int a : x)
			sum += a;
		return sum;
	}
	public static void main(String[] args) {
		Methods13 method =new Methods13();
		int sum = method.sum(10,50,90,500,0,-50,-100);
		System.out.println("Sum of the numbers are: " + sum);
	}
}