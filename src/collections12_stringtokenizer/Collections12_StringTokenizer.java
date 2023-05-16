package collections12_stringtokenizer;

import java.io.FileInputStream;
import java.util.*;

public class Collections12_StringTokenizer {
	public static void main(String[] args) throws Exception {
		//This is a key value pair stored in a single line of a String.
		//Each keys and values are tokens and with the help of the String Tokenizer, we can extract
		//the tokens.
		//'=' and ';' signs are delimiters. We can have more or less delimiters.
		//New line can be used as a delimiter as well.
		String data = "name=John;address=texas;country=usa;dept=cse";
		//Creating an object of String Tokenizer and defining the delimiters.
		StringTokenizer stk =new StringTokenizer(data, "=;");
		//hasMoreElements and hasMoreTokens do the same thing.
		while(stk.hasMoreElements()) 
			System.out.println(stk.nextToken());
		
		//Tokenizing a file:
		System.out.println("\nTokenizing a file:");
		FileInputStream fis =new FileInputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections12_stringtokenizer/data.txt");
		byte b[] =new byte[fis.available()];
		fis.read(b);
		
		String data2 =new String(b);
		
		StringTokenizer stk2 =new StringTokenizer(data2, "=");
		while(stk2.hasMoreElements()) 
			System.out.println(stk2.nextToken());
		fis.close();
		
		//Creating an array and inserting numbers from a file.
		System.out.println("\nNumbers: ");
		FileInputStream fis2 =new FileInputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections12_stringtokenizer/numbers.txt");
		ArrayList<Integer> al =new ArrayList<>();
		byte b2[] =new byte[fis2.available()];
		fis2.read(b2);
		String data3 =new String(b2);
		StringTokenizer stk3 =new StringTokenizer(data3, ",");
		while(stk3.hasMoreElements()) 
			al.add(Integer.valueOf(stk3.nextToken()));
		System.out.println(al);
		fis2.close();
	}
}