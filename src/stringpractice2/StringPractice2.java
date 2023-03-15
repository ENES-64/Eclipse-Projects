package stringpractice2;

public class StringPractice2 {
	public static void main(String[] args) {
		String str = "java";
		int length = str.length();
		System.out.println(length);
		
		String str2 = "  Java   ";
		str2 = str2.trim();
		System.out.println(str2);
		
		String str3 = "unpossiblely";
		str3 = str3.substring(2, 10);
		System.out.println(str3);
		
		String str4 = "WOW";
		str4 = str4.replace('W','V');
		System.out.println(str4);
		
		int count_commas = -1, count_dots = -1, i = -1, j = -1;
		String str5 = ",,,..,..,,..,,.,.,..,.,.,...,.,..,.,.,,,,.,,,.,..,,..,,,";
		//A program can be written in many ways. This one being the worst.
		while(i>=-1) {
			i = str5.indexOf('.',++i);
			count_dots++;
			if(i==-1)
				break;
		}
		while(j>=-1) {
			j = str5.indexOf(',',++j);
			count_commas++;
			if(j==-1)
				break;
		}
		System.out.println(str5+"\nNumber of dots: "+count_dots+".\nNumber of commas: "+count_commas+'.');
	}
}