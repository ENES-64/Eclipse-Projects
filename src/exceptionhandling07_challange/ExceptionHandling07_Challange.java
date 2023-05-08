package exceptionhandling07_challange;

import java.util.Scanner;

@SuppressWarnings("serial")
class OverFlowException extends Exception {
	@Override
	public String toString() {
		return "Stack overflow.";
	}
}
@SuppressWarnings("serial")
class UnderFlowException extends Exception {
	@Override
	public String toString() {
		return "Stack underflow.";
	}
}

public class ExceptionHandling07_Challange {
	static Scanner sc =new Scanner(System.in);
	static int stack[] =new int [5];
	
	static void push(int top) throws Exception {
		if(top==5)
			throw new OverFlowException();
		System.out.println("Enter a number: ");
		stack[top] = sc.nextInt();
		System.out.println("Stack added.");
	}
	static void pop(int top) throws Exception {
		if(top==0)
			throw new OverFlowException();
		stack[top-1] = 0;
		System.out.println("Stack removed.");
	}
	
	public static void main(String[] args) throws Exception {
		int top = 0;
		while(true) {
			System.out.println("Type A to add or D to delete. Type E to exit.");
			String option = sc.next();
			if(option.equalsIgnoreCase("e"))
				return;
			if(option.equalsIgnoreCase("a")) {
				push(top);
				top++;
			}
			else if(option.equalsIgnoreCase("d")) {
				pop(top);
				top--;
			}else
				System.out.println("Wrong option entered. Try again.");
		}
	}
}