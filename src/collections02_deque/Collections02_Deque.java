package collections02_deque;

import java.util.ArrayDeque;

public class Collections02_Deque {
	public static void main(String[] args) {
		//ArrayDeque is like queue, but we can add or remove from both sides.
		//It takes constant time to add or remove. Which means it's probably starts adding
		//elements somewhere in the middle of the array.
		ArrayDeque<Integer> dq =new ArrayDeque<>();
		
		dq.offerLast(10);
		dq.offerLast(20);
		
		dq.offerFirst(0);
		dq.offerFirst(-10);
		dq.offerFirst(-20);
		
		dq.forEach(x->System.out.println(x));
		
		System.out.println();
		
		dq.pollFirst();
		dq.pollLast();
		
		dq.forEach(x->System.out.println(x));
	}
}