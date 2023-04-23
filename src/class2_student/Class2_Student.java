package class2_student;

public class Class2_Student {
	public int roll, m1, m2, m3;
	public String name, course;
	
	public int total() {
		return m1 + m2 + m3;
	}
	public float average() {
		return ((float) (m1 + m2 + m3) / 3);
	}
	public char grade() {
		if(Math.round(average())>70)
			return 'A';
		if(Math.round(average())>60)
			return 'B';
		if(Math.round(average())>50)
			return 'C';
		if(Math.round(average())>40)
			return 'D';
		return 'F';
	}
	//If you have a toString named method that returnds a string value,
	//and you call print with this class' reference,
	//this method is called automatically.
	public String toString() {
		return ("Name: " + name + ".\nEnrollment number: " + roll + ".\nCourse: " + course + '.');
	}
}