package advancedclass08_interfaceexample2;

import advancedclass08_icamera.AdvancedClass08_ICamera;
import advancedclass08_imusicplayer.AdvancedClass08_IMusicPlayer;
import advancedclass08_phone.AdvancedClass08_Phone;
import advancedclass08_smartphone.AdvancedClass08_SmartPhone;

public class AdvancedClass08_InterfaceExample2 {
	public static void main(String[] args) {
		AdvancedClass08_Phone phone =new AdvancedClass08_SmartPhone();
		phone.call();
		System.out.println();
		AdvancedClass08_IMusicPlayer music =new AdvancedClass08_SmartPhone();
		music.play();
		System.out.println();
		AdvancedClass08_ICamera camera =new AdvancedClass08_SmartPhone();
		camera.click();
		System.out.println();
		AdvancedClass08_SmartPhone smartPhone =new AdvancedClass08_SmartPhone();
		smartPhone.videoCall();
		smartPhone.click();
		smartPhone.play();
		smartPhone.call();
	}
}