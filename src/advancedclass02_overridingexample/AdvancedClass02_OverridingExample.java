package advancedclass02_overridingexample;

import advancedclass02_oldtv.AdvancedClass02_OldTV;
import advancedclass02_smarttv.AdvancedClass02_SmartTV;

public class AdvancedClass02_OverridingExample {
	public static void main(String[] args) {
		AdvancedClass02_OldTV oldTV =new AdvancedClass02_OldTV();
		oldTV.switchOn();
		oldTV.changeChannel();
		System.out.println();
		AdvancedClass02_SmartTV smartTV =new AdvancedClass02_SmartTV();
		smartTV.switchOn();
		smartTV.changeChannel();
		smartTV.browse();
		System.out.println();
		//You can call a Smart TV as Old TV, but can't call Old TV as Smart TV.
		//This works.
		AdvancedClass02_OldTV tv =new AdvancedClass02_SmartTV();
		//This doesn't.
		//AdvancedClass02_SmartTV tv2 =new AdvancedClass02_OldTV();
		tv.switchOn();
		tv.changeChannel();
	}
}