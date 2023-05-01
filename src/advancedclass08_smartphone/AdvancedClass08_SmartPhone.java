package advancedclass08_smartphone;

import advancedclass08_icamera.AdvancedClass08_ICamera;
import advancedclass08_imusicplayer.AdvancedClass08_IMusicPlayer;
import advancedclass08_phone.AdvancedClass08_Phone;

public class AdvancedClass08_SmartPhone extends AdvancedClass08_Phone implements AdvancedClass08_ICamera, AdvancedClass08_IMusicPlayer {
	public void videoCall() { System.out.println("Smart Phone video calling"); }
	@Override
    public void click() { System.out.println("Smart Phone Clicking Photo"); }
	@Override
    public void record() { System.out.println("Smart Phone recording video"); }
    @Override
    public void play() { System.out.println("Smart Phone playing music"); }
    @Override
    public void stop() { System.out.println("Smart Phone stopped playing music"); }
}