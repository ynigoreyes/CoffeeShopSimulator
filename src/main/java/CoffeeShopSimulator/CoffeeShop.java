package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.EventBus.Events.CoffeeShopEvent;
import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.EventBus.ICoffeeShopEventBus;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Order;
import CoffeeShopSimulator.Models.Person;
import CoffeeShopSimulator.Utilities.ILogger;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * CoffeeShop
 *
 * An entry for interacting with the coffee shop directly.
 * Here, we should be able to add/remove people from the
 * coffee shop and whatever else is needed in the future
 */
public class CoffeeShop implements ICoffeeShop {
    private static ICoffeeShopEventBus coffeeShopEventBus;

    /**
     * Creates a Coffee Shop
     *
     * The eventBus is needed so that everyone that is
     * in the coffee shop can listen to each other
     */
    public CoffeeShop(EventBus eventBus, ILogger logger) {
        coffeeShopEventBus = new CoffeeShopEventBus(eventBus, logger);
        eventBus.register(coffeeShopEventBus);
        eventBus.register(this);


        setup();
    }

    public static void addEventToCoffeeShop(CoffeeShopEvent e){
        coffeeShopEventBus.sendEvent(e);
    }

    /**
     * Starts the entire coffee shop doing whatever
     * works needs to be done to get it up and running
     *
     * TODO: Fill in this block comment with what is going to happen to start off the simulation
     */
    private void setup() {
        // Anything for set up can go here
    }

    public void handleAddingPersonToCoffeeShop(Person person) {
        if (person instanceof Customer) {
            coffeeShopEventBus.sendEvent(new NewCustomerWalksInEvent((Customer) person));
        }

        // Handle the different types of people leaving here
    }

    public void handleRemovingPersonFromCoffeeShop(Person person) {
        if (person instanceof Customer) {
            coffeeShopEventBus.sendEvent(new CustomerLeavesEvent((Customer) person));
        }

        // Handle the different types of people leaving here
    }

    public void handleCustomerGetOrder(Person person) {
        if (person instanceof Customer) {
            coffeeShopEventBus.sendEvent(new CustomerGetOrderEvent((Customer) person));
        }

        // Handle the different types of people leaving here
    }



    public void exampleMethodToUseInUI(Object data) {
        System.out.println(data);
    }

    @Subscribe
    public void handleCustomerGettingInLine(Person person) {
        if (person instanceof Customer) {
            coffeeShopEventBus.sendEvent(new CustomerLeavesEvent((Customer) person));
        }
    }
}
