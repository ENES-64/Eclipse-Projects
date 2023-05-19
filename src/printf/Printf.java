package printf;

public class Printf {
	public static void main(String[] args) {
		/* EXPLAINATION FOR 'printf' AND 'format':
		 * %[argument index '$'][flags][width][dot precision '.']conversion
		 * 
		 * argument index: '1$ - 2$ - 3$'
		 * 
		 * flags:
		 * '-' = left alignment
		 * '+' = show the sign of a number
		 * '0' = fill empty spaces with 0s
		 * '(' = if the number is negative put it in parentheses
		 * 
		 * width: allocate places
		 * 
		 * dot precision: limit the numbers after the decimal point
		 * 
		 * conversion: 
		 * char = c
		 * int in decimal = d
		 * int in octal = o
		 * int in hexadecimal = x
		 * float or double = f
		 * float in scientific notation = e or g
		 * String = s
		 */
		float f = 0f, f2 = 0.5f, f3 = 1f, f4 = 1.5f;
		int i = 50, i2 = 100, i3 = 150;
		System.out.format("%2$+06.2f\n", f, f2, f3, f4);
		System.out.printf("%3$-7x|<-- 7 places total.", i, i2, i3);
	}
}