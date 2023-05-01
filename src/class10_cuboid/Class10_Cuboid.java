package class10_cuboid;

import class10_rectangle.Class10_Rectangle;

public class Class10_Cuboid extends Class10_Rectangle{
	int height;
    int x=20;
    
    public Class10_Cuboid(int l,int b,int h)	 {
    	//Using super() to refer to the super class's constructor.
        super(l,b);
        height=h;
    }
    
    public void display() {
    	//Using super to refer to the super class's x varible instead of the current subclass's x variable.
        System.out.println(super.x);
        System.out.println(x);
    }
}