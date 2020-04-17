package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;

public class CustomerCollectOrderEvent extends CoffeeShopEvent {

    private Customer customer;

    public CustomerCollectOrderEvent(Customer customer){
        super("CustomerCollectOrderEvent");
        this.customer = customer;
    }

    public Customer getCustomer(){return customer;}

}
