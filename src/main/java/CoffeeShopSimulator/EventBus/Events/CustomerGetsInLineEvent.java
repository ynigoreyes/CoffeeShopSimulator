package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;
import java.util.ArrayList;

public class CustomerGetsInLineEvent extends CoffeeShopEvent{

    private Customer customer;

    public CustomerGetsInLineEvent(Customer customer) {
        super("CustomerGetsInLineEvent");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
