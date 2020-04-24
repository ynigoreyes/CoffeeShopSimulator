package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.EventBus.Events.BaristaMakeAndServeAllOrdersEvent;
import CoffeeShopSimulator.EventBus.Events.BaristaTakeNextOrderEvent;

import java.util.HashSet;

public class Barista extends Person {

    private HashSet<Order> ordersTaken = new HashSet<>();

    public Barista(String name) {
        super(name);
    }

    public void takeNextOrder(){
        CoffeeShop.addEventToCoffeeShop( new BaristaTakeNextOrderEvent(this) );
    }

    public void makeAndServeAllOrders() {
        CoffeeShop.addEventToCoffeeShop( new BaristaMakeAndServeAllOrdersEvent(this, (HashSet<Order>) ordersTaken.clone() ) );
        ordersTaken = new HashSet<>();
    }

    public void tookOrder(Order o){
        ordersTaken.add(o);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Barista)";
    }
}
