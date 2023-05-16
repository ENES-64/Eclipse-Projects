package databasetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter; 
import java.util.Scanner;
//Some database shenanigans.
public class databasetest {
	//This value should be 62 in the end.
	static int checkedSettings = 0;
	
	static void setSetting(String setting, int[] allsettings) throws Exception {
		int mode = Integer.parseInt(setting.substring(setting.indexOf(":") + 1, setting.length()));
		setting = setting.substring(0, setting.indexOf(":"));
		switch(setting) {
			/* No idea what this phenomenon is called. 
			2	4	8	16	32
			
			6	6	10	18	34
			10	12	12	20	36
			14	14	14	22	38
			18	20	24	24	40
			22	22	26	26	42
			26	28	28	28	44
			30	30	30	30	46
			34	36	40	48	48
			38	38	42	50	50
			42	44	44	52	52
			44	46	46	54	54
			50	52	56	56	56
			54	54	58	58	58
			58	60	60	60	60
			62	62	62	62	62
			*/
			case "favoriteitem": allsettings[0] = mode; checkedSettings += 2; break;
			case "averagetime": allsettings[1] = mode; checkedSettings += 4; break;
			case "refunds": allsettings[2] = mode; checkedSettings += 8; break;
			case "disruptions": allsettings[3] = mode; checkedSettings += 16; break;
			case "totalvisits": allsettings[4] = mode; checkedSettings += 32; break;
			default: allsettings[5]++;
		}
	}
	
	public static void main(String[] args) {
		int[] allsettings =new int[6];
		String settings = "";
		File file = new File("/Users/enesy/MyJava/Eclipse/MyEclipse/src/databasetest/somedata.txt");		
		try(FileInputStream fi =new FileInputStream(file);Scanner sc =new Scanner(fi)) {
			sc.useDelimiter("\\Z");
			settings = sc.next();
			settings = settings.toLowerCase();
			settings = settings.strip();
		} catch (Exception e) {}
		
		for(int i=0;i<5;i++) {
			String temp = settings;
			try {
				temp = temp.substring(0, temp.indexOf(";"));
				setSetting(temp, allsettings);
				settings = settings.substring(settings.indexOf(";") + 1, settings.length());
			} catch(Exception e) {}
		}
		String favoritemenu;
		switch(allsettings[0]) {
			case 0: favoritemenu = "Meat"; break;
			case 1: favoritemenu = "Hamburger"; break;
			case 2: favoritemenu = "Chicken"; break;
			case 3: favoritemenu = "Pizza"; break;
			case 4: favoritemenu = "Cake"; break;
			case 5: favoritemenu = "Pasta"; break;
			default: favoritemenu = "Unknown"; break;
		}
		if((checkedSettings & 2) != 0)
			System.out.println("Favorite menu: " + favoritemenu);
		else
			System.out.println("Favorite menu: Missing");
		if((checkedSettings & 4) != 0)
			System.out.println("Average visit time: " + allsettings[1]);
		else
			System.out.println("Average visit time: Missing");
		if((checkedSettings & 8) != 0)
			System.out.println("Total refunds: " + allsettings[2]);
		else
			System.out.println("Total refunds: Missing");
		if((checkedSettings & 16) != 0)
			System.out.println("Total disruptions: " + allsettings[3]);
		else
			System.out.println("Total disruptions: Missing");
		if((checkedSettings & 32) != 0)
			System.out.println("Total visits: " + allsettings[4]);
		else
			System.out.println("Total visits: Missing");
		if(allsettings[5]>0)
			System.out.println("Total unknown settings: " + allsettings[5]);
		
		if(checkedSettings!=62) {
			try(FileWriter write = new FileWriter(file, true);) {
				//First setting:
				if((checkedSettings & 2) == 0)
					write.write("favoriteitem:0;");
				if((checkedSettings & 4) == 0)
					write.write("averagetime:0000;");
				if((checkedSettings & 8) == 0)
					write.write("refunds:0;");
				if((checkedSettings & 16) == 0)
					write.write("disruptions:0;");
				if((checkedSettings & 32) == 0)
					write.write("totalvisits:0;");
				System.out.println("Missing settings have been added.");
			} catch (IOException e) {}
		}
	}
}