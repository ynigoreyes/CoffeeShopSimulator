package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;

/**
 * Event for when customers walk out of the coffee shop
 */

public class CustomerGetOrderEvent extends CoffeeShopEvent {
    private Customer customer;
    private int orderNumber;

    public CustomerGetOrderEvent(Customer customer, int orderNumber) {
        super("CustomerGetOrder");
        this.customer = customer;
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }
}
