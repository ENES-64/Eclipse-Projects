package advancedclass02_smarttv;

import advancedclass02_oldtv.AdvancedClass02_OldTV;

public class AdvancedClass02_SmartTV extends AdvancedClass02_OldTV {
	@Override
	public void switchOn() { System.out.println("Smart TV switched on."); }
	@Override
	public void changeChannel() { System.out.println("Smart TV channel changed."); }
	
	public void browse() { System.out.println("Smart TV browsing."); }
}