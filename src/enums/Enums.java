package enums;

/*
In an enum, we can have defined constants.
Enum constants should be written in all capital.
Constructor must be private or default.
Constructor is called for every constant in enum.
Constructors must be parameterized if the constants have some property.
There can be methods in enums.
 */
enum Dept {
    CS("John","Block A"),IT("Smith","Block B"),CIVIL("Srinivas","Block C"),ECE("Dave","Block D");
    
    String head;
    String location;
    
    private Dept(String head,String loc) {
        this.head = head;
        this.location = loc;
    }
    public String getHeadName() {
        return head;
    }
    public String getLocation() {
        return location;
    }
}


public class Enums {
	public static void main(String[] args) {
		//To declare a reference of type enum, we should assign a constant from that enum.
		Dept d = Dept.CS;
        
        System.out.println(d.getHeadName());
        System.out.println(d.getLocation());
	}
}