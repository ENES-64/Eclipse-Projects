package switchcase2;

import java.util.Scanner;

public class SwitchCase2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number, and an arithmetic operator, then another number:\n(+, -, *, /, %)");
		float num = sc.nextFloat(), result = 0f;
		String operation = sc.next();
		float num2 = sc.nextFloat();
		switch(operation){
			case "+":
				result = num + num2;
				break;
			case "-":
				result = num - num2;
				break;
			case "*":
				result = num * num2;
				break;
			case "/":
				result = num / num2;
				break;
			case "%":
				result = num % num2;
				break;
			default:
				operation = "error";
		}
		if(operation.equals("error")==true)
			System.out.println("Wrong arithmetic operator entered.");
		else
			System.out.println("Result: " + result);
	}
}