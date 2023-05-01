package advancedclass03_luxurycar;

import advancedclass03_car.AdvancedClass03_Car;

public class AdvancedClass03_LuxuryCar extends AdvancedClass03_Car {
	@Override
	public void changeGear() { System.out.println("Automatic gear."); }
	public void openRoof() { System.out.println("Sun roof is opened."); }
}