package class9_inheritconstparam;

import class9_child.Class9_Child;
import class9_parent.Class9_Parent;

public class Class9_InheritConstParam {
	public static void main(String[] args) {
		Class9_Parent parent =new Class9_Parent();
		System.out.println();
		Class9_Parent parent2 =new Class9_Parent(0);
		System.out.println();
		Class9_Child child =new Class9_Child();
		System.out.println();
		Class9_Child child2 =new Class9_Child(0);
		System.out.println();
		Class9_Child child3 =new Class9_Child(1,2);
	}
}