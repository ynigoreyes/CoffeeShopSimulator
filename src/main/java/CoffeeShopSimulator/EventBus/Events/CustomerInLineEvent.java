package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;
import java.util.ArrayList;

public class CustomerInLineEvent extends CoffeeShopEvent{

    public CustomerInLineEvent(Customer customer) {
        super("CostomerInLineEvent");
        line.add(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

}
