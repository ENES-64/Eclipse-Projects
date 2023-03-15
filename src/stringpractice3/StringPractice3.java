package stringpractice3;

public class StringPractice3 {

	public static void main(String[] args) {
		String name = "Dr. John Johnson";
		
		String male = "He who calls himself '";
		String female = "She who calls herself '";
		String unknown = "They who wish to differ and call themselves '";

		if(name.startsWith("Mr.")==true)
			System.out.println(male + name.substring(4) + "'");
		else if(name.startsWith("Ms.")==true)
			System.out.println(female + name.substring(4) + "'");
		else
			System.out.println(unknown + name + "'");
	}
}