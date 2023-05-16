package collections08_linkedhashmap;

import java.util.*;

public class Collections08_LinkedHashMap {
	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<>();
		//LinkedHashMap is same as HashMap except it has 2 nodes that links the previous and next
		//values in order. So, we can traverse in LinkedHashMaps.
		//We can order the elements depending on the recent access.
		//LinkedHashMap takes constant time.
        LinkedHashMap<Integer,String> lhm=new LinkedHashMap<>();

        hm.put(5,"E");
        hm.put(1,"A");
        hm.put(4, "D");
        hm.put(2, "B");
        hm.put(3,"C");
        hm.put(6,"A");
        
        lhm.put(5,"E");
        lhm.put(1,"A");
        lhm.put(4,"D");
        lhm.put(2,"B");
        lhm.put(3,"C");
        lhm.put(6,"A");
        
        System.out.println(hm);
        System.out.println(lhm.get(5));
        lhm.put(4,"K");
        lhm.get(1);
        System.out.println(lhm);
	}
}