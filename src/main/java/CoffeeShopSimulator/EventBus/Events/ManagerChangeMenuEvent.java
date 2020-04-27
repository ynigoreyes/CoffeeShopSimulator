package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Manager;

import java.util.HashMap;

public class ManagerChangeMenuEvent extends CoffeeShopEvent {

    private Manager manager;
    private HashMap<String, Double> newMenu;

    public ManagerChangeMenuEvent(Manager manager, HashMap<String, Double> newMenu) {
        super("ManagerChangeMenuEvent");
        this.manager = manager;
        this.newMenu = newMenu;
    }

    public Manager getManager() {
        return manager;
    }

    public HashMap<String, Double> getNewMenu(){
        return newMenu;
    }
}
