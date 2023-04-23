package class3_master;
import java.util.Scanner;
import class3_datahiding.Class3_DataHiding;

public class Class3_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Class3_DataHiding datahiding =new Class3_DataHiding();
		
		for(int i=0;i==0;) {
			System.out.println("\nType 'GL' or 'GB' to get length or breadth.");
			System.out.println("Type 'SL' or 'SB' to set length or breadth.");
			System.out.println("Type 'R' to see the result. (Type anything else to exit.)");
			switch(sc.next()) {
				//Get data.
				case "GL": case "gl": case "gL": case "Gl": 
					System.out.println("Length is: " + datahiding.getLength());
					break;
				case "GB": case "gb": case "gB": case "Gb": 
					System.out.println("Breadth is: " + datahiding.getBreadth());
					break;
				//Set data.
				case "SL": case "sl": case "sL": case "Sl": 
					System.out.println("Enter length:");
					datahiding.setLength(sc.nextInt());
					break;
				case "SB": case "sb": case "sB": case "Sb": 
					System.out.println("Enter breadth:");
					datahiding.setBreadth(sc.nextInt());
					break;
				//See the result.
				case "R": case "r":
					System.out.println(datahiding); 
					break;
				//Exit.
				default: 
					i++;
			}
		}
	}
}