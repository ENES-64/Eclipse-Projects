package advancedclass03_overridingexample2;

import advancedclass03_car.AdvancedClass03_Car;
import advancedclass03_luxurycar.AdvancedClass03_LuxuryCar;

public class AdvancedClass03_OverridingExample2 {
	public static void main(String[] args) {
		AdvancedClass03_Car car =new AdvancedClass03_Car();
		car.start();
		car.accelerate();
		car.changeGear();
		System.out.println();
		AdvancedClass03_LuxuryCar luxuryCar =new AdvancedClass03_LuxuryCar();
		luxuryCar.start();
		luxuryCar.accelerate();
		luxuryCar.changeGear();
		luxuryCar.openRoof();
		System.out.println();
		//Don't adopt the features that comes with the luxury car unless it's overrided.
		AdvancedClass03_Car luxuryCar2 =new AdvancedClass03_LuxuryCar();
		luxuryCar2.start();
		luxuryCar2.accelerate();
		luxuryCar2.changeGear();
		//luxuryCar2.openRoof();
	}
}