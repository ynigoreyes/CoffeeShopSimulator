package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.EventBus.Events.CoffeeShopEvent;
import CoffeeShopSimulator.EventBus.Events.ManagerChangeMenuEvent;

import java.util.HashMap;

public class Manager extends Person {

    private HashMap<String, Double> menuOne = new HashMap<>();
    private HashMap<String, Double> menuTwo = new HashMap<>();
    private String currentMenu = "one";

    public Manager(String name) {
        super(name);

        menuOne.put("Latte", 5.99);
        menuOne.put("Coffee", 3.95);
        menuOne.put("Water", 0.01);
        menuOne.put("Biscuit", 2.99);
        menuOne.put("Croissant", 2.99);

        menuTwo.put("Fancy Latte", 50.99);
        menuTwo.put("Fancy Coffee", 30.95);
        menuTwo.put("Fancy Water", 2.00);
        menuTwo.put("Fancy Biscuit", 20.99);
        menuTwo.put("Fancy Croissant", 20.99);

    }

    public void changeMenu(){
        if( currentMenu.equals("two") ){
            CoffeeShop.addEventToCoffeeShop( new ManagerChangeMenuEvent(this, menuOne));
            currentMenu = "one";
        }
        else{
            CoffeeShop.addEventToCoffeeShop( new ManagerChangeMenuEvent(this, menuTwo));
            currentMenu = "two";
        }
    }

    @Override
    public String toString(){
        return super.toString() + "(a Manager)";
    }
}
