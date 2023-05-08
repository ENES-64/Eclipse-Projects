package exceptionhandling06_trywithresources;

import java.io.FileInputStream;
import java.util.Scanner;

public class ExceptionHandling06_TryWithResources {
	static void divide() throws Exception {
		int a, b, c, d, e, f;
		//FileInputStream uses a file within the package.
		//Using FileInputStream as an input for Scanner instead of using keyboard.
		try(FileInputStream fi =new FileInputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/exceptionhandling06_trywithresources/exceptionhandling06_trywithresources_text.txt");Scanner sc =new Scanner(fi)) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			e = sc.nextInt();
			f = sc.nextInt();
			System.out.println(e/a);
		} /* We don't need this since we put the resource inside try and it will automatically close.
		finally {
			//This code will get executed whether there is an exception or not.
			//This is useful for clean up since we want to make sure to close the resources.
			fi.close();
			sc.close();
		}*/
	}
	
	public static void main(String[] args) {
		try {
			divide();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End.");
	}
}