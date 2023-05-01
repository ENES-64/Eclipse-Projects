package advancedclass09_store;

import advancedclass09_imember.AdvancedClass09_IMember;

public class AdvancedClass09_Store {
	AdvancedClass09_IMember mem[] =new AdvancedClass09_IMember[100];
	private int count = 0;
	
	public void register(AdvancedClass09_IMember m) {
		mem[count++] = m;
	}
	public void inviteSale() {
		for(int i=0;i<count;i++)
			mem[i].callBack();
	}
}