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
public class CoffeeShopEventBus {
    private final EventBus eventBus;
    private final ILogger logger;

    public CoffeeShopEventBus(EventBus eventBus, ILogger logger) {
        this.eventBus = eventBus;
        this.logger = logger;
    }

    /**
     * Sends events for other people in the coffee shop to listen for.
     * Event's will follow an always-once dispatch policy (will only send one time)
     *
     * @param e the event that will be listened to
     */
    public void sendEvent(Object e) {
        eventBus.post(e);
    }

    /**
     * Handles the addition of new customers to the coffee shop
     *
     * @param e the event to listen for
     */
    @Subscribe
    public void handleNewCustomer(NewCustomerWalksInEvent e) {
        logger.Log(e.getCustomer().getName() + " arrived!");
        addPersonToCoffeeShop(e.getCustomer());
    }

    /**
     * Handles the removal of customers from the coffee shop
     *
     * @param e the event to listen for
     */
    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e) {
        logger.Log(e.getCustomer().getName() + " left!");
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
