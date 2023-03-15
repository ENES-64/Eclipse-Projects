package boringmath2;
import java.util.Scanner;

public class BoringMath2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length, breadth, and height:");
		float length = sc.nextFloat();
		float breadth = sc.nextFloat();
		float height = sc.nextFloat();
		
		float totalArea = 2f * (length * height + breadth * height + length * breadth);
		float volume = length * breadth * height;
		
		System.out.println("Volume of this cuboid is " + volume + ", and the total area is " + totalArea);
	}
}