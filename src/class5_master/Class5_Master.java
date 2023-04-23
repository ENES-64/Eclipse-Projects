package class5_master;
import java.util.Scanner;
import class5_cylinder.Class5_Cylinder;

public class Class5_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Class5_Cylinder cc =new Class5_Cylinder(55,32);
		
		System.out.println("Radius = " + cc.getRadius() + ". Height = " + cc.getHeight() + '.');
		System.out.println("Lid area: " + cc.lidArea() + '.');
		System.out.println("Total surface area: " + cc.totalSurfaceArea() + '.');
		System.out.println("Volume: " + cc.volume() + '.');
		System.out.println("Circumference: " + cc.circumference() + '.');
	}
}