package collections06_comparable;

import java.util.*;
//Custom comparator.
class Point implements Comparable<Point> {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x = " + x + " y = " + y;
	}
	@Override
	public int compareTo(Point p) {
		if(this.x<p.x)
			return -1;
		if(this.x>p.x)
			return 1;
		if(this.y<p.y)
			return -1;
		if(this.y>p.y)
			return 1;
		return 0;
	}
}

public class Collections06_Comparable {
	public static void main(String[] args) {
		//Creating a TreeSet collection that holds objects.
		//Which means a custom comparator is needed.
		TreeSet<Point> ts =new TreeSet<>();
		
		ts.add(new Point(1, 1));
		ts.add(new Point(5, 5));
		ts.add(new Point(5, 2));
		
		System.out.println(ts);
	}
}