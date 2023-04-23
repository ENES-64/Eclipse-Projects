package class4_master;
import java.util.Scanner;
import class4_typesofproperty.Class4_TypesOfProperty;


public class Class4_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Constructing the class with some values, so not all default values are zero.
		//This will use preset values within the class if there is one.
		//This is called non-parameterized constractor.
		Class4_TypesOfProperty type =new Class4_TypesOfProperty();
		//This will pass these values as a preset to the class.
		//This is called parameterized constractor.
		Class4_TypesOfProperty type2 =new Class4_TypesOfProperty(1998, "History");
		
		System.out.println("Enter 1 to use the type object, or enter any other number to use the type2 object:");
		if(sc.nextInt()==1) {
			System.out.println("Your roll number is: " + type.getRoll());
			System.out.println("Enter three marks:");
			type.setMarks(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			System.out.println("Your current course is: " + type.getCourse() + ".\nDo you want to swap courses?(Y/N)");
			if(sc.next().equalsIgnoreCase("y")==true) {
				System.out.println("Enter the name of the course:");
				type.setCourse(sc.next());
				System.out.println("Your current course has been changed to " + type.getCourse() + '.');
			}
		}else {
			System.out.println("Your roll number is: " + type2.getRoll());
			System.out.println("Enter three marks:");
			type2.setMarks(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			System.out.println("Your current course is: " + type2.getCourse() + ".\nDo you want to swap courses?(Y/N)");
			if(sc.next().equalsIgnoreCase("y")==true) {
				System.out.println("Enter the name of the course:");
				type2.setCourse(sc.next());
				System.out.println("Your current course has been changed to " + type2.getCourse() + '.');
			}
		}
	}
}