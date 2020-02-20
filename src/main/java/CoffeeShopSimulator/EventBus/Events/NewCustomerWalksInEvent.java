package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;

/**
 * Event for when new customers walk into the coffee shop
 */
public class NewCustomerWalksInEvent extends CoffeeShopEvent {
    private Customer customer;

    public NewCustomerWalksInEvent(Customer customer) {
        super("NewCustomerWalksIn");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
