package advancedclass14_singletonexample;

import advancedclass14_coffeemachine.AdvancedClass14_CoffeeMachine;

public class AdvancedClass14_SingletonExample {
	public static void main(String[] args) {
		AdvancedClass14_CoffeeMachine cm1=AdvancedClass14_CoffeeMachine.getInstance();
		AdvancedClass14_CoffeeMachine cm2=AdvancedClass14_CoffeeMachine.getInstance();
		AdvancedClass14_CoffeeMachine cm3=AdvancedClass14_CoffeeMachine.getInstance();
        
        System.out.println(cm1+"\n"+cm2+"\n"+cm3);
        if(cm1==cm2 && cm1==cm3)
            System.out.println("All the objects are the same.");
	}
}