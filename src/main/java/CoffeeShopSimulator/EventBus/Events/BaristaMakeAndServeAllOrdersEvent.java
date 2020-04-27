package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Order;

import java.util.HashSet;

public class BaristaMakeAndServeAllOrdersEvent extends CoffeeShopEvent {

    private Barista barista;
    private HashSet<Order> orders;

    public BaristaMakeAndServeAllOrdersEvent(Barista barista, HashSet<Order> orders){
        super("BaristaMakeAndServeAllOrdersEvent");
        this.barista = barista;
        this.orders = orders;
    }

    public Barista getBarista(){return barista;}

    public HashSet<Order> getOrders(){return orders;}
}
