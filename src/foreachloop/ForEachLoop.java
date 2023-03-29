package foreachloop;

import java.util.Arrays;
import java.util.List;

public class ForEachLoop {
	public static void main(String[] args) {
		String str = "mortalkombat";
		String[] eachChar= str.split("");
		
		System.out.println(str);
		System.out.println(Arrays.toString(eachChar));
		
		for(String each : eachChar) {
			
			System.out.println(each);
		}
	}
}
