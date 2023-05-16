package collections10_linkedhashset;

import java.util.*;

public class Collections10_LinkedHashSet {
	public static void main(String[] args) {
		//The only difference between LinkedHashSet and LinkedHashMap is 
		//LinkedHashSet only takes values while LinkedHashMap takes keys and values and 
		//LinkedHashSet's size can't be limited.
		LinkedHashSet<String> lhs =new LinkedHashSet<>(10);
		
		lhs.add("A");
		lhs.add("C");
		lhs.add("E");
		lhs.add("K");
		lhs.add("B");
		lhs.add("G");
		lhs.add("B");
		
		//LinkedHashSet is not ordered unlike HashSet.
		lhs.forEach(System.out::println);
	}
}