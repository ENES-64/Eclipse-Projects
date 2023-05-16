package collections09_linkedhashmapascache;

import java.util.*;

public class Collections09_LinkedHashMapAsCache {
	public static void main(String[] args) {
		//The third argument in the LinkedHashMap's contructor decides whether to use 
		//order of access or not. If true, least used keys will be the first.
		//To limit the size, we have to override a method inside the LinkedHashMap class.
		//We can do it using an anonymous class.
		@SuppressWarnings("serial")
		LinkedHashMap<Integer, String> lhm =new LinkedHashMap<>(5, 0.75f, true) {
			//It must be protected only.
			@SuppressWarnings("rawtypes")
			@Override
			protected boolean removeEldestEntry(Map.Entry e) {
				//If the size is greater than 5, start removing entries.
				return size()>5;
			}
		};
		
		lhm.put(1, "A");
		lhm.put(2, "B");
		lhm.put(3, "C");
		lhm.put(4, "D");
		lhm.put(5, "E");
		
		//Accessing the keys.
		lhm.get(2);
		lhm.get(5);
		lhm.get(1);
		lhm.put(6, "F");
		
		lhm.forEach((k, v) -> System.out.println(k + " = " + v));
	}
}