package stringpractice4;

public class StringPractice4 {
	public static void main(String[] args) {
		String str1 = "JAVA";
		String str2 = "java";
		
		int i = str1.compareTo(str2);
		System.out.println(i + '\n');
		
		String str3 = String.valueOf(12345);
		System.out.println(str3 + '\n' + str3.length() + '\n');
		
		String str4 = "Apple", str5 = "apple", str6 = new String("Apple");
		System.out.println(str4.equals(str5));
		System.out.println(str4.equalsIgnoreCase(str5));
		System.out.print('\n');
		System.out.println(str4.equals(str6));
		System.out.println(str4==str6);
	}
}