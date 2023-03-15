package stringpracticeexpressionschallange3;

import java.util.Scanner;

public class StringPracticeExpressionsChallange3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String str = sc.nextLine();
		str = str.replaceAll("\\W&&\\S", "").replaceAll("\\s+", " ").trim();
		System.out.println(str);
		String words[] = str.split("\\s");
		System.out.println("There are " + words.length + " words.");
	}
}