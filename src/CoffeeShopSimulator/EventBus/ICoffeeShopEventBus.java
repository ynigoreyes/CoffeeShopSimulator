package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;

public interface ICoffeeShopEventBus {
    /**
     * Sends events for other people in the coffee shop to listen for.
     * Event's will follow an always-once dispatch policy (will only send one time)
     *
     * @param e the event that will be listened to
     */
    void sendEvent(Object e);

    /**
     * Handles the addition of new customers to the coffee shop
     *
     * @param e the event to listen for
     */
    void handleNewCustomer(NewCustomerWalksInEvent e);

    /**
     * Handles the removal of customers from the coffee shop
     *
     * @param e the event to listen for
     */
    void handleCustomerLeaving(CustomerLeavesEvent e);
}
