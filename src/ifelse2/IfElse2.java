package ifelse2;

import java.util.Scanner;

public class IfElse2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type a website:");
		String website = sc.nextLine();
		
		String protocol = website.substring(0, 4);
		if(protocol.equalsIgnoreCase("http") == true)
			System.out.println("The protocol is: Hyper text transfer protocol.");
		else {
			if(protocol.equalsIgnoreCase("ftp:") == true)
				System.out.println("The protocol is: File transfer protocol.");
			else
				System.out.println("The protocol is: Unknown.");
		}
		int index = website.lastIndexOf(".");
		String websiteType = website.substring(index);
		if(websiteType.equalsIgnoreCase(".com"))
			System.out.println("The website type is: Commercial.");
		else if(websiteType.equalsIgnoreCase(".gov"))
			System.out.println("The website type is: Government.");
		else if(websiteType.equalsIgnoreCase(".org"))
			System.out.println("The website type is: Organization.");
		else if(websiteType.equalsIgnoreCase(".net"))
			System.out.println("The website type is: Network.");
		else if(websiteType.equalsIgnoreCase(".biz"))
			System.out.println("The website type is: Business.");
		else {
			index = website.lastIndexOf(".", index - 1);
			if(website.lastIndexOf(".", index - 1) != -1)
				websiteType = website.substring(index, 3 + index);
			if(websiteType.equalsIgnoreCase(".co"))
				System.out.println("The website type is: Commercial.");
			else
				System.out.println("The website type is: Unknown.");
		}
	}
}