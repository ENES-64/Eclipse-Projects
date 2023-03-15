package stringpractice;

public class StringPractice {
	public static void main(String[] args) {
		/* Important methods:
		 * int length()
		 * String toLowerCase()
		 * String toUpperCase()
		 * String trim()
		 * String substring(int begin)
		 * String substring(int begin, int end)
		 * String replace(char old, char new)
		 * boolean startsWith(String str)
		 * boolean endsWith(String str)
		 * char charAt(int index)
		 * int indexOf(String str, int index)
		 * int lastIndexOf(String str, int index)
		 * boolean equals(String str) - It compares the contents, whereas '==' compares the references.
		 * boolean equalsIgnoreCase(String str)
		 * int compareTo(String str)
		 * String valueOf(jnt/long/float/double/char/char[]/boolean/Object x)
		 * String valueOf(char[] data, int offset, int count)
		 * String concat(String str) - Combine the two strings.
		 */
		String str1 = "Yava";
		String str2 = new String("Java");
		
		char c[] = {'a','W','o','w','!','?','¡'};
		String str3 = new String(c, 1, 4);	//(char, int[starting index], int[length])
		
		byte b[] = {65,66,67,68};	//A B C D
		String str4 = new String(b, 0, 2);	//(byte, int[starting index], int[length])
		
		System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + '\n');
		
		String str5 = "Java";
		str5 += 'w';
		
		System.out.println(str5);
	}
}