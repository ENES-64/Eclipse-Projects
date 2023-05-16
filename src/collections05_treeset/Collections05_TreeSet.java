package collections05_treeset;

import java.util.*;

public class Collections05_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> ts =new TreeSet<>(List.of(10,30,50,70,10,40));
		
		ts.add(25);
		
		//Ceiling returns a number equal or greater than the number given.
		System.out.println(ts.ceiling(55));
		//Floor does the opposite of ceiling.
		System.out.println(ts.floor(55));
		
		System.out.println(ts);
	}
}