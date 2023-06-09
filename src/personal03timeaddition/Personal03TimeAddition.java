package personal03timeaddition;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Personal03TimeAddition {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		Scanner sc =new Scanner(System.in);
		double money;
		System.out.println("Type P to enter pay rate. Type T to enter the total earning.");
		String option = sc.next();
		while(true) {
			if(option.equalsIgnoreCase("p")) {
				System.out.println("Enter dollars per hour: ");
				money = sc.nextDouble()/60;
				break;
			}else if(option.equalsIgnoreCase("t")) {
				System.out.println("Enter the total earning: ");
				money = sc.nextDouble();
				break;
			}else
				System.out.println("Wrong option entered. Try again.");
		}
		System.out.println("Enter as many hours and minutes you want for addition |<HOUR> <MINUTE>|:\n(Enter a negative number to see the result)");
		int hour = 0, minute = 0, total = 0;
		while(hour >= 0 && minute >= 0) {
			total = total + minute + (hour * 60);
			hour = sc.nextInt();	minute = sc.nextInt();
		}
		System.out.println("TOTAL: " + total/60 + " hours and " + total%60 + " minutes. ");
		if(option.equalsIgnoreCase("p"))
			System.out.println("$" + df.format((double) (money * 60)) + " per hour. Total of $" + df.format((double) (money * total)) + '.');
		else
			System.out.println("$" + df.format((double) (60 * (money / total))) + " per hour. Total of $" + df.format((double) (money * (total / 60))) + '.');
		sc.close();
	}
}

/* ALT VERSION:

import java.text.DecimalFormat;
import java.util.Scanner;

public class Personal03TimeAddition {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		Scanner sc =new Scanner(System.in);
		System.out.println("Saat başı doları girin: ");
		double money = sc.nextDouble()/60;
		System.out.println("İki tane saati askerî saat formatında giriniz: ");
		System.out.println("Örn: 1030 1830");
		System.out.println("(Bitirmek için negatif numara giriniz)");
		int firstTime = 0, secondTime = 0, total = 0;
		while(true) {
			int hours, minutes;
			firstTime = sc.nextInt();
			if(firstTime < 0)
				break;
			secondTime = sc.nextInt();
			hours = secondTime / 100 - firstTime / 100;
			minutes = secondTime % 100 + (60 - firstTime % 100);
			if(minutes > 0)
				hours--;
			total += hours * 60 + minutes;
		}
		System.out.println(total/60 + " saat ve " + total%60 + " dakika. ");
		System.out.println("Saat başına $" + df.format((double) (money * 60)) + ". Toplam kazanç ise $" + df.format((double) (money * total)) + '.');
		sc.close();
	}
}
*/