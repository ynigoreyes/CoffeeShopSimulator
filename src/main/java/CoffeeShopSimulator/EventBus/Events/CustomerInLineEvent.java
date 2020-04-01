package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;
import java.util.ArrayList;

public class CustomerInLineEvent extends CoffeeShopEvent{

    ArrayList<Customer> line = new ArrayList<Customer>();

    private Customer customer;

    public CustomerInLineEvent(Customer customer) {
        super("CostomerInLineEvent");
        customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
