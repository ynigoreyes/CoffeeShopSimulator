package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.Models.Person;
import CoffeeShopSimulator.Utilities.ILogger;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is a Guava Event Bus wrapper.
 * This was mainly created for abstraction so that
 * if we ever decide to switch event bus providers, we
 * won't have to rewrite as much code
 */
public class CoffeeShopEventBus implements ICoffeeShopEventBus {
    private final EventBus eventBus;
    private final ILogger logger;

    public CoffeeShopEventBus(EventBus eventBus, ILogger logger) {
        this.eventBus = eventBus;
        this.logger = logger;
    }

    public void sendEvent(Object e) {
        eventBus.post(e);
    }

    @Subscribe
    public void handleNewCustomer(NewCustomerWalksInEvent e) {
        logger.Log(e.getCustomer() + " arrived!");
        addPersonToCoffeeShop(e.getCustomer());
    }

    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e) {
        logger.Log(e.getCustomer() + " left!");
        removePersonFromCoffeeShop(e.getCustomer());
    }

    /**
     * Adds a person to the coffee shop so that they can also listen for events
     *
     * @param person the person to add to the coffee shop
     */
    private void addPersonToCoffeeShop(Person person) {
        eventBus.register(person);
    }

    /**
     * Removes a person from the coffee shop so that the are no longer listening for events
     *
     * @param person the person to remove from the coffee shop
     */
    private void removePersonFromCoffeeShop(Person person) {
        eventBus.unregister(person);
    }
}
