package collections07_treemap;

import java.util.*;
import java.util.Map.*;

public class Collections07_TreeMap {
	public static void main(String[] args) {
		//Map stores a key and its value.
		//Key is stored as integer, value is stored as string.
		//TreeMap takes Log n time while HashMap takes constant time.
		//In TreeMap, elements will be sorted. In HashMap, elements won't be sorted.
		TreeMap<Integer, String> tm =new TreeMap<>(Map.of(0, "A", 1, "B", 2, "C", 3, "D"));
		
		tm.put(4, "E");
		tm.put(6, "G");
		tm.put(4, "X");
		
		//CeilingEntry returns a value equal or greater than the given value.
		System.out.println(tm.ceilingEntry(5).getValue());
		
		System.out.println(tm.get(3));
		
		System.out.println(tm);
		
		//Entry won't work on HashMap.
		Entry<Integer, String> e =tm.firstEntry();
		System.out.println(e.getKey() + " " + e.getValue());
		}
}