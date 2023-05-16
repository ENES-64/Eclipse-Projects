package bitsetexample;

import java.util.*;

public class BitSetExample {
	public static void main(String[] args) {
		BitSet bs1 =new BitSet();
		//Setting even indexes true in this bitset.
		for(int i=0;i<=8;i+=2)
			bs1.set(i);
			
		BitSet bs2 =new BitSet();
		//Setting odd indexes true in this bitset.
		for(int i=1;i<=8;i+=2)
			bs2.set(i);
		
		bs1.flip(0,bs1.length());
		bs1.or(bs2);
		
		System.out.println(bs1);
	}
}