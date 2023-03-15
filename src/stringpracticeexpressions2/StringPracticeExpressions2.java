package stringpracticeexpressions2;

public class StringPracticeExpressions2 {
	public static void main(String[] args) {
		/* boolean matches(String regex)
		 * Regular expressions cont:
		 * * = 0 or more time
		 * + = One or more
		 * ? = 0 or 1 time
		 * {X} = X times
		 * {X, Y} = Between X and Y times
		 */
		String str1 = "cbcbaabcbabbcc";
		System.out.println(str1);
		System.out.println(str1.matches("[abc]*"));
		System.out.println(str1.matches("[ab]*"));
		System.out.println(str1.matches("[abc]+"));
		
		String str2 = "b";
		System.out.println('\n' + str2);
		System.out.println(str2.matches("[abc]?"));
		System.out.println(str2.matches("[ac]?"));
		
		String str3 = "aaabbc";
		System.out.println('\n' + str3);
		System.out.println(str3.matches("[abc]{3}"));
		System.out.println(str3.matches("[abc]{6}"));
		System.out.println(str3.matches("[abc]{5,8}"));
	}
}