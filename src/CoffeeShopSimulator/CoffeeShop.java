package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.EventBus.ICoffeeShopEventBus;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Utilities.ILogger;
import com.google.common.eventbus.EventBus;

public class CoffeeShop {
    private ICoffeeShopEventBus coffeeShopEventBus;

    /**
     * Creates a Coffee Shop
     * <p>
     * The eventBus is needed so that everyone that is
     * in the coffee shop can listen to each other
     */
    public CoffeeShop(EventBus eventBus, ILogger logger) {
        coffeeShopEventBus = new CoffeeShopEventBus(eventBus, logger);
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
