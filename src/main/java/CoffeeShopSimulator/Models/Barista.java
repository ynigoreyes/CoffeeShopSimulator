package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.EventBus.Events.CustomerGetOrderEvent;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashSet;

public class Barista extends Person {
    public Barista(String name) {
        super(name);
    }

    private HashSet<Order> Orders = new HashSet<>();

    @Override
    public String toString(){
        return super.toString() + "(a Barista)";
    }

    @Subscribe
    public void handleCustomerGetOrder(CustomerGetOrderEvent e){

        Orders.remove()
    }
}
