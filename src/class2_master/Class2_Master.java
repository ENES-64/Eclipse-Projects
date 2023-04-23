package class2_master;
import java.util.Scanner;
import class2_student.Class2_Student;

public class Class2_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Class2_Student stud =new Class2_Student();
		
		System.out.println("Enter your name:");
		stud.name = sc.next();
		System.out.println("Enter your enrollment number:");
		stud.roll = sc.nextInt();
		System.out.println("Enter your course name:");
		stud.course = sc.next();
		System.out.println("Enter your three marks:");
		stud.m1 = sc.nextInt();
		stud.m2 = sc.nextInt();
		stud.m3 = sc.nextInt();
		
		//Check toString method in Class2_Student class for more information about this line.
		System.out.println(stud);
		
		System.out.println("Total: " + stud.total() + '.');
		System.out.printf("Average: %.2f.", stud.average());
		System.out.println("\nGrade: " + stud.grade() + '.');
	}
}