package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;

/**
 * Event for when customers walk out of the coffee shop
 */
public class CustomerLeavesEvent extends CoffeeShopEvent {
    private Customer customer;

    public CustomerLeavesEvent(Customer customer) {
        super("CustomerLeaves");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
