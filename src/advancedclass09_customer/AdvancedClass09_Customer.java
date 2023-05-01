package advancedclass09_customer;

import advancedclass09_imember.AdvancedClass09_IMember;

public class AdvancedClass09_Customer implements AdvancedClass09_IMember {
	private String name;
	public AdvancedClass09_Customer(String name) {
		this.name = name;
	}
	public void callBack() {
		System.out.println("'Ok. I will visit.' - " + name);
	}
}