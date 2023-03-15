package stringpracticeexpressionsmeta;

public class StringPracticeExpressionsMeta {
	public static void main(String[] args) {
		/* boolean matches(String regex)
		 * Meta Characters:
		 * \d = Digit
		 * \D = Not digit
		 * \s = Space
		 * \S = Not space
		 * \w = Alphabet or digit
		 * \W = Neither alphabet or digit
		 * 
		 * \ is an escape character. Use \\ which becomes a regular \.
		 */
		String str1 = "5";
		System.out.println(str1);
		System.out.println(str1.matches("\\d"));
		System.out.println(str1.matches("\\D"));
		
		String str2 = "%";
		System.out.println('\n' + str2);
		System.out.println(str2.matches("\\w"));
		System.out.println(str2.matches("\\W"));
		
		String str3 = " ";
		System.out.println('\n' + str3);
		System.out.println(str3.matches("\\s"));
		System.out.println(str3.matches("\\S"));
	}
}
