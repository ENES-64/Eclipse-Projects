package advancedclass14_coffeemachine;

public class AdvancedClass14_CoffeeMachine {
	private float coffeQty;
    private float milkQty;
    private float waterQty;
    private float sugarQty;
    //An object of this class is assigned to this varible.
    //It is static, because a static method accesses to this varible.
    static private AdvancedClass14_CoffeeMachine cm =null;
    //Constructor is private since we want to control
    //the amount of objects created from this class.
    private AdvancedClass14_CoffeeMachine() {
        coffeQty=1;
        milkQty=1;
        waterQty=1;
        sugarQty=1;
    }
    
    public void fillWater(float qty) {
        waterQty=qty;
    }
    public void fillSugar(float qty) {
        sugarQty=qty;
    }
    public float getCoffee() {
        return 0.15f;
    }
    //This method checks if cm holds an object. If not, create an object and assign 
    //cm to the created object, else return cm.
    //Since it returns only cm, we essentially only allowed cm to hold an object of this class.
    //So this is a singleton class.
    //It is static, because we can't create an object of this class freely, 
    //we have to access to this method somehow in the main method.
    public static AdvancedClass14_CoffeeMachine getInstance() {
        if(cm==null)
            cm =new AdvancedClass14_CoffeeMachine();
        return cm;
    }
}