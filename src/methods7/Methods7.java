package methods7;
import java.util.Scanner;

//Method overloading.
public class Methods7 {
	//When overloading, method name and parameters are checked. Return type is ignored.
	int max(int a, int b) {return a > b ? a : b;}
	
	int max(int a, int b, int c) {return a > b && a > c ? a : (b > c ? b : c);}
	
	int max(int a, int b, int c, int d) {return a > b && a > c ? a : (b > c && b > d ? b : (c > d ? c : d));}
	
	float max(float a, float b) {return a > b ? a : b;}
	
	float max(float a, float b, float c) {return a > b && a > c ? a : (b > c ? b : c);}
	
	float max(float a, float b, float c, float d) {return a > b && a > c ? a : (b > c && b > d ? b : (c > d ? c : d));}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods7 method =new Methods7();
		String option = null;
		int option2 = 0, result = 0;
		float result2 = 0f;
		for(int i=0;i==0;) {
			System.out.println("What type of numbers would you like to enter?\n(INT or FLOAT)");
			option = sc.nextLine();
			if(option.equalsIgnoreCase("INT") || option.equalsIgnoreCase("FLOAT")==true)
				i = 1;
			else
				System.out.println("Wrong option entered.");
		}
		for(int i=0;i==0;) {
			System.out.println("How many numbers would you like to enter?\n(2-4)");
			option2 = sc.nextInt();
			if(option2>=2 && option2<=4)
				i = 1;
			else
				System.out.println("Wrong option entered.");
		}
		if(option.equalsIgnoreCase("INT")==true)
			switch(option2) {
				case 2: result = method.max(sc.nextInt(), sc.nextInt()); break;
				case 3: result = method.max(sc.nextInt(), sc.nextInt(), sc.nextInt()); break;
				case 4: result = method.max(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		else
			switch(option2) {
				case 2: result2 = method.max(sc.nextFloat(), sc.nextFloat()); break;
				case 3: result2 = method.max(sc.nextFloat(), sc.nextFloat(), sc.nextFloat()); break;
				case 4: result2 = method.max(sc.nextFloat(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
			}
		if(option.equalsIgnoreCase("INT")==true)
			System.out.println("Largest number you entered is: " + result + '.');
		else
			System.out.println("Largest number you entered is: " + result2 + '.');
	}
}