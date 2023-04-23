package personal01datedifference;
import java.util.Scanner;

//Program finds the difference between 2 dates given by the user.
//It's as accurate as it can be with no imports other than 'java.util.Scanner.'
public class Personal01DateDifference {
	//Declaring this on top instead of in class to be able to call a method from a method.
	static Personal01DateDifference method =new Personal01DateDifference();
	//Check if the given string is in a date format or not.
	boolean dateCheck(String str, long[] date, int index) {
		//Make sure given string is in MM/DD/Y... format before start validating.
		if(str.matches("[0-9][0-9]/[0-9][0-9]/\\d*")==false)
			return false;
		//Turn the string into numbers to compare.
		method.turnDateIntoNums(str, date, index);
		//make sure months are not out of range.
		if(date[index]<1 && date[index]>12)
			return false;
		//make sure days are not out of range,
		if(date[index+1]<1 && date[index+1]>31)
			return false;
		//If it is a leap year and the month is February, accept up to 29 days instead of 28 days.
		if(date[index]==2 && method.isItLeapYear(date[index+2])==true && date[index+1]<=29)
			return true;
		//Compare days to its month to make sure it's not out of range.
		if(method.findDaysOfMonth((int) (date[index]))>=date[index+1])
			return true;
		return false;
	}
	//Parse the string to 6 longs; days, months, years, and again for the second date.
	//If the current time was used, parsing is skipped.
	void turnDateIntoNums(String str, long[] date, int index) {
		date[index] = Long.parseLong(str.substring(0, str.indexOf('/')));
		date[index+1] = Long.parseLong(str.substring(3, str.indexOf('/')+3));
		date[index+2] = Long.parseLong(str.substring(6, str.length()));
	}
	//Formats local time for use. Don't bother making sense out of this. It just works.
	void formatSystemTime(long date[], int option) {
		//System time started counting from 0 on January 1, 1970.
		//Add the rest in days.
		long years, totalDays = ((((System.currentTimeMillis()/1000)/60)/60)/24)+719050;
		years = totalDays/365;
		for(int i=1970;i<years;i++)
			if(i==years)
				break;
			else if(method.isItLeapYear(i)==true)
				totalDays++;
		double days, months = (double) ((totalDays%365)/30.437f);
		if(method.isItLeapYear(years)==true && months > 2)
			totalDays++;
		//No clue how this one line fixes everything.
		totalDays += 7;
		days = (double) (((totalDays%365)%30.437f));
		date[option] = (long) months; 
		date[option+1] = (long) days; 
		date[option+2] = years;
	}
	//Finds and returns how many days in the given month.
	int findDaysOfMonth(int month) {
		switch(month) {
			//Months that are 31 days.
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			//Months that are 30 days.
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			//February.
			default:
				return 28;
		}
	}
	//Returns true if it's a leap year.
	boolean isItLeapYear(long year) {
		if(year%4 == 0)
			if(year%100 == 0) 
				return (year%400 == 0);
			else 
				return true;
		return false;
	}
	//Print the differences between the two dates.
	void printDifferences(double dateCount[], String year, String month, String week, String day, int index) {
		//Don't print it if it's less than 1.
		//index variable decides which point to start printing.
		if(index==0) {
				if(dateCount[3] >= 1)
					System.out.print((long) (dateCount[3]) + year);
				if(dateCount[3] >= 1 && dateCount[2] >= 1)
					System.out.print(", ");
				if(dateCount[2] >= 1)
					System.out.print((int) (dateCount[2]) + month);
		}
		if(index<=1) {
				if(dateCount[3] >= 1 && dateCount[1] >= 1 || dateCount[2] >= 1 && dateCount[1] >= 1)
					System.out.print(", ");
				if(dateCount[1] >= 1)
					System.out.print((int) (dateCount[1]) + week);
				if(dateCount[3] >= 1 && dateCount[0] >= 1 || dateCount[2] >= 1 && dateCount[0] >= 1 || dateCount[1] >= 1 && dateCount[0] >= 1)
					System.out.print(", ");
				if(dateCount[0] >= 1)
					System.out.print((int) (Math.round(dateCount[0])) + day);
		}
			System.out.print('.');
	}
	//main.
	public static void main(String[] args) {
		//Suppress the warning of scanner.
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//Variable to know whether current time was used or not.
		int option = 0;
		//1 dimensional array with 6 elements stores the given dates.
		//First 3 elements store months, days, and years of the earliest date.
		//Last 3 elements store the latest date.
		long[] date =new long [6];
		String firstDate = null, secondDate = null;
		//Asks user to enter the first date then validates the format.
		for(int i=0;i==0;) {
			System.out.println("Enter the first date(MM/DD/YYYY):\nType T to use the current time.");
			firstDate = scanner.next();
			if(firstDate.equalsIgnoreCase("t")) {
				method.formatSystemTime(date, 0);
				option++;
				i++;
			}else if(method.dateCheck((firstDate), date, 0)==false)
				System.out.println("Wrong format used.");
			else
				i++;
		}
		//Asks user to enter the second date then validates the format.
		for(int i=0;i==0;) {
			System.out.println("Enter the second date(MM/DD/YYYY): ");
			//Make sure in the first date, current time was used, before asking it again.
			if(option==0)
				System.out.println("Type T to use the current time.");
			secondDate = scanner.next();
			//Don't allow current time to be used again.
			if(secondDate.equalsIgnoreCase("t") && option == 0) {
				method.formatSystemTime(date, 3);
				i++;
			}else if(method.dateCheck((secondDate), date, 3)==false)
				System.out.println("Wrong format used.");
			else
				i++;
		}
		//Break out of the program if both of the dates are same.
		if(date[0] == date[3] && date[1] == date[4] && date[2] == date[5]) {
			System.out.println("You entered the same date.");
			return;
		}
		//If the first given date is later than the second given date, swap them.
		if((date[2]>date[5]) || (date[1]>date[4] && date[2]==date[5]) || (date[0]>date[3] && date[1]==date[4] && date[2]==date[5]))
			for(int i=0;i<3;i++) {
				long temp = date[i];
				date[i] = date[i+3];
				date[i+3] = temp;
			}
		//First element is the sum of the years, months, and days in days.
		//Second element is the sum of leap years that occurred between the two dates.
		long[] sum =new long[2];
		//If years and the months are the same, just find the difference between days.
		if(date[2] == date [5] && date[0] == date[3]) {
			sum[0] = date[4] - date[1];
		//If years are the same, just find the difference between months and days.
		}else if(date[2] == date[5]) {
			//Add needed days to complete the month and add the leftover days from the last month.
			sum[0] += method.findDaysOfMonth((int) (date[0])) - (int) (date[1]) + date[4];
			//Find and add the rest of the months.
			for(int i=(int) (date[0]+1);i<date[3];i++) 
				sum[0] += method.findDaysOfMonth(i);
			//If it is a leap year. If so, add a leap year.
			if(method.isItLeapYear(date[2]) == true && date[0] <= 2 && date[1] <= 28 && date[3] >=2 && date[4] > 28)
				sum[1]++;
		
		}else {
			//find the difference between the two dates.
			//Years to days.
			for(long j=date[2];j<date[5];j++) {
				if(method.isItLeapYear(j))
					sum[1]++;
				sum[0] += 365;
			}
			//I have no idea why, but this fixes the added extra year that happens out of nowhere.
			sum[0] -= 365;
			//Months to days.
			//First half.
			for(int j =(int) (date[0]);j<=12;j++) {
				sum[0] += method.findDaysOfMonth(j);
				if(j==date[0])
					sum[0] -= date[1];
			}
			//Second half.
			for(int j =(int) (date[3]-1);j>=1;j--) {
				sum[0] += method.findDaysOfMonth(j);
			}
			//Add the leftover days that was skipped from second half.
			sum[0] += date[4];
		}
		//Add the leap days 
		sum[0] += sum[1];
		//Printing the result.
		System.out.println("The difference between the two dates:");
		//Store words and change it to plural if needed.
		String day = " day", month = " month", week = " week", year = " year";
		//Store days, weeks, months, and years in one array.
		double[] dateCount =new double[4];
		//30.437 is the average length of a month in a year.
		//Taking the average means longer the gap between the dates, less accurate differences.
		//Not sure if it's possible to get that 100% accurate without any imports.
		dateCount[0] = Math.round((sum[0]%365)%30.437f)%7;
		dateCount[1] = ((sum[0]%365)%30.437f/7);
		dateCount[2] = (sum[0]%365)/30.437f;
		dateCount[3] = sum[0]/365;
		//Add an 's' to the string if it's more than 1.
		//Differences to show.
		if((int) (dateCount[0])!=1)
			day = day + 's';
		if((int) (dateCount[1])!=1) 
			week = week + 's';
		if((int) (dateCount[2])!=1) 
			month = month + 's';
		if((int) (dateCount[3])!=1)
			year = year + 's';
		//Print the differences.
		method.printDifferences(dateCount, year, month, week, day, 0);
		//Add extra text about leap years if there is at least one leap year.
		if(sum[1]==1)
			System.out.print(" There was 1 leap year.");
		else if(sum[1]>1)
			System.out.print(" There were " + sum[1] + " leap years.");
		//Printing the differences in another way.
		//Since 4 weeks don't always equal to a month,
		//calculate the days without calling printDifferences method.
		if(dateCount[3] >= 1 || dateCount[2] >= 1 || dateCount[1] >= 1) {
			System.out.print("\nOr: ");
			if(dateCount[3] >= 1) {
				System.out.print((int) (Math.round(sum[0]/30.437f)) + " months");
				method.printDifferences(dateCount, year, month, week, day, 1);
			}else if(dateCount[2] >= 1) {
				System.out.print(sum[0]/7 + " weeks");
				System.out.print((int) (Math.round(sum[0]%365)%7) >= 1 ? (", " + ((int) (Math.round(sum[0]%365)%7))) : "");
				if((int) (Math.round(sum[0]%365)%7) == 1)
						System.out.print(" day.");
				else if((int) (Math.round(sum[0]%365)%7) > 1)
					System.out.print(" days.");
				else
					System.out.print('.');
			}else if(dateCount[1] >= 1)
				System.out.print(sum[0] + " days.");
			//Printing the differences in yet another way.
			if(dateCount[3] >= 1 || dateCount[2] >= 1) {
				System.out.print("\nOr: ");
				if(dateCount[3] >= 1) {
					System.out.print(sum[0]/7 + " weeks");
					System.out.print(((int) (Math.round(sum[0]%365)%7)) >= 1 ? (", " + ((int) (Math.round(sum[0]%365)%7))) : "");
					if((int) (Math.round(sum[0]%365)%7) == 1)
							System.out.print(" day.");
					else if((int) (Math.round(sum[0]%365)%7) > 1)
						System.out.print(" days.");
					else
						System.out.print('.');
				}else if(dateCount[2] >= 1)
					System.out.print(sum[0] + " days.");
				//Printing the differences in yet another way for the last time.
				if(dateCount[3] >= 1)
					System.out.print("\nOr: " + sum[0] + " days.");
			}
		}
		//Print obscure differences with the user's wish.
		System.out.println("\nDo you want to see more differences?(Y/N)");
		if(scanner.next().equalsIgnoreCase("y")) {
			System.out.println("The difference is: " + sum[0]*24 + " hours, or " + (sum[0]*24)*60 + " minutes, or " + ((sum[0]*24)*60)*60 + " seconds.");
			int totalLeapYears = 0;
			for(int i=4;i<date[2];i+=4)
				if(method.isItLeapYear(i)==true)
					totalLeapYears++;
			System.out.println("Total of leap years until the earliest date: " + totalLeapYears + '.');
		}
		//For debugging purposes.
		System.out.println("Enter D to debug. Enter anything else to exit.");
		if(scanner.next().equalsIgnoreCase("d")) {
			System.out.print("dates[]: ");
			for(int i=0;i<date.length;i++)
				System.out.print(date[i] + " ");
			System.out.println("\nsum[1](leaps) = " + sum[1] + ", sum[0](days) = " + sum[0]);
			System.out.println("Strings: " + day + month + week + year);
			System.out.println("dateCount[]: " + dateCount[3] + ' ' + dateCount[2] + ' ' + dateCount[1] + ' ' + dateCount[0]);
			System.out.println("Current time: " + System.currentTimeMillis());
		}
	}
}