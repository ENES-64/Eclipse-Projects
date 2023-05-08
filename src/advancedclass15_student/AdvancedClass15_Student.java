package advancedclass15_student;

import java.util.Date;

public class AdvancedClass15_Student {
private String rollNo;
    //This varible incremants by one everytime a contructor of this class is called.
    private static int count=1;
    
    private String assignRollNo() {
        Date d=new Date();
        
        @SuppressWarnings("deprecation")
		String rno="Univ-"+(d.getYear()+1900)+"-"+count;
        count++;
        return rno;
    }
    public AdvancedClass15_Student() {
        rollNo=assignRollNo();
    }
    public String getRollNo() {
        return rollNo;
    }
}