package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Utilities.ILogger;
import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;

public class CoffeeShop {
    public static ILogger Logger = new Logger();

    private CoffeeShopEventBus coffeeShopEventBus;

    /**
     * Creates a Coffee Shop
     *
     * The eventBus is needed so that everyone that is
     * in the coffee shop can listen to each other
     */
    public CoffeeShop() {
        EventBus eventBus = new EventBus();
        coffeeShopEventBus = new CoffeeShopEventBus(eventBus);
        eventBus.register(coffeeShopEventBus);
    }

    /**
     * Starts the entire coffee shop doing whatever
     * works needs to be done to get it up and running
     */
    public void start() {
        Customer firstCustomer = new Customer("Rajeev");

        coffeeShopEventBus.sendEvent(new NewCustomerWalksInEvent(firstCustomer));
        coffeeShopEventBus.sendEvent(new CustomerLeavesEvent(firstCustomer));
    }
}
