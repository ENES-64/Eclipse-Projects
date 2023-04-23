package methods11;

public class Methods11 {
	//Variable argument.
	//x is an array that can take as many values as given.
	//'...' means it will convert given values to an array if it's not an array.
	static void show(int... x) {
		for(int a : x)
			System.out.print(a + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		show();
		show(10);
		show(10,20,30,40,50,60,70,80,90,100);
		show(new int[] {1,2,3,4,5,6,7,8,9,10});
	}
}