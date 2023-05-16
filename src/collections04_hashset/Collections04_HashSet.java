package collections04_hashset;

import java.util.HashSet;

public class Collections04_HashSet {
	public static void main(String[] args) {
		//50% load is the best for efficiency and above 75% is not efficient. Default is 75%.
		//Hash is useful for constant time for adding and removing.
		HashSet<Integer> hs =new HashSet<>(20, 0.25f);
		
		hs.add(10);
		hs.add(20);
		hs.add(30);
		//This 10 won't be added since duplicates are not allowed.
		hs.add(10);
		
		System.out.println(hs);
	}
}