package collections03_priorityqueue;

import java.util.*;

class CustomComparator implements Comparator<Integer> {
	//Custom comparator that prioritizes higher values.
	public int compare(Integer x, Integer y) {
		if(x<y)
			return 1;
		if(y<x) 
			return -1;
		return 0;
	}
}
public class Collections03_PriorityQueue {
	public static void main(String[] args) {
		//Priority queue compares values and by default, lowest values have priority over higher values.
		//Custom comparator should be written for some objects or it will throw an exception.
		//Deletion takes Log n time.	
		PriorityQueue<Integer> pq =new PriorityQueue<>();
		
		pq.add(20);
		pq.add(10);
		pq.add(30);
		pq.add(5);
		pq.add(15);
		pq.add(0);
		
		System.out.println(pq.peek());
		System.out.println();
		
		pq.forEach(x->System.out.println(x));
		System.out.println();
		
		pq.poll();
		pq.forEach(x->System.out.println(x));
		System.out.println();
		
		//Same settings, but this time, instead of the default comparator,
		//a custom one is used, which prioritizes higher numbers.
		PriorityQueue<Integer> pq2 =new PriorityQueue<>(new CustomComparator());
		pq2.add(20); pq2.add(10); pq2.add(30); pq2.add(5); pq2.add(15); pq2.add(0);
		
		pq2.forEach(x->System.out.println(x));
	}
}