package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.EventBus.ICoffeeShopEventBus;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Person;
import CoffeeShopSimulator.Utilities.ILogger;
import com.google.common.eventbus.EventBus;

/**
 * CoffeeShop
 *
 * Only entry point for interacting with the coffee shop directly.
 * Consider this the API that the UI will use. Add methods here that
 * will be used by those who are developing the UI
 */
public class CoffeeShop implements ICoffeeShop {
    private ICoffeeShopEventBus coffeeShopEventBus;

    /**
     * Creates a Coffee Shop
     *
     * The eventBus is needed so that everyone that is
     * in the coffee shop can listen to each other
     */
    public CoffeeShop(EventBus eventBus, ILogger logger) {
        coffeeShopEventBus = new CoffeeShopEventBus(eventBus, logger);
        eventBus.register(coffeeShopEventBus);

        setup();
    }

    /**
     * Starts the entire coffee shop doing whatever
     * works needs to be done to get it up and running
     *
     * TODO: Fill in this block comment with what is going to happen to start off the simulation
     */
    private void setup() {
        Customer firstCustomer = new Customer("Rajeev");

        coffeeShopEventBus.sendEvent(new NewCustomerWalksInEvent(firstCustomer));
        coffeeShopEventBus.sendEvent(new CustomerLeavesEvent(firstCustomer));
    }


    public void exampleMethodToUseInUI(Object data) {
        System.out.println(data);
    }

    public void addPeople(Person person) {
        System.out.println(person);
    }
}
