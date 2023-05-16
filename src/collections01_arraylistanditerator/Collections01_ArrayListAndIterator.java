package collections01_arraylistanditerator;

import java.util.*;

public class Collections01_ArrayListAndIterator {
	public static void main(String[] args) {
		//Creating an array list with a size of 20.
		//We can also use LinkedList which is a collection of data linked with nodes.
		//So, inserting and removing is easier, but nodes also take space in the memory.
		//LinkedArrays' size can extend and reduce dynamically without creating a bigger or smaller one.
		ArrayList<Integer> al1 =new ArrayList<>(20);
		//Creating an array list and initializing it.
		ArrayList<Integer> al2 =new ArrayList<>(List.of(50,60,70,80,90));
		
		al1.add(10);
		al1.add(0, 5);
		al1.addAll(1, al2);
		
		System.out.println(al1.contains(50));
		//Get the element on the fifth index.
		System.out.println(al1.get(5));
		System.out.println(al1.indexOf(70));
		al1.add(70);
		System.out.println(al1.lastIndexOf(70));
		al1.remove(7);
		System.out.println(al1.lastIndexOf(70));
		al1.set(6, 100);
		System.out.println(al1);
		al1.retainAll(al2);
		
		//Iterator. Can only traverse in one direction.
		Iterator<Integer> it = al1.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		//List iterator. Can traverse in both directions and set the current iteration's value.
		//We can also use for loop instead and initialize the iterator within the for loop.
		for(ListIterator<Integer> lit = al1.listIterator(al1.size()); lit.hasPrevious();)
			System.out.print(lit.previous() + " ");
		System.out.println();
		//Another way of printing the array.
		al1.forEach(System.out::print);
		System.out.println();
		//Yet another way of printing the array using lambda expression.
		al1.forEach(x->traverse(x));
	}
	//Print numbers above 60.
	static void traverse(int x) {
		if(x>60)
			System.out.print(x + " ");
	}
}