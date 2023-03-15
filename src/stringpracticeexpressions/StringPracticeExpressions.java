package stringpracticeexpressions;

public class StringPracticeExpressions {
	public static void main(String[] args) {
		/* boolean matches(String regex)
		 * Regular expressions:
		 * . = Any character
		 * [abc] = Exactly given letters or numbers
		 * [abc][vz] = Either first or the second set
		 * [^abc] = Except given letters or numbers
		 * [a-z1-9] = Between given letters or numbers
		 * A|B = First or the second
		 * XZ = Exactly given letters or numbers as is
		 */
		String str1 = "5";
		System.out.println(str1);
		System.out.println(str1.matches("."));
		
		String str2 = "c";
		System.out.println('\n' + str2);
		System.out.println(str2.matches("[abc]"));
		System.out.println(str2.matches("[ab]"));
		System.out.println(str2.matches("[a-d]"));
		
		String str3 = "b5";
		System.out.println('\n' + str3);
		System.out.println(str3.matches("[abc][1-9]"));
		System.out.println(str3.matches("[ABC][1-9]"));
		System.out.println(str3.matches("[abc][10-100]"));
		System.out.println(str3.matches("[1-9][abc]"));
		System.out.println(str3.matches("[^xyz][^10-100]"));
		
		String str4 = "a";
		System.out.println('\n' + str4);
		System.out.println(str4.matches("A|a"));
		
		String str5 = "Wow";
		System.out.println('\n' + str5);
		System.out.println(str5.matches("wow"));
		System.out.println(str5.matches("Wow"));
	}
}