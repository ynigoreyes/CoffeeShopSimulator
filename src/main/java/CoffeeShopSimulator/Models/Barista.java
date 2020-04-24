package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.EventBus.Events.BaristaMakeAndServeAllOrdersEvent;
import CoffeeShopSimulator.EventBus.Events.BaristaTakeNextOrderEvent;
import CoffeeShopSimulator.EventBus.Events.CustomerGetOrderEvent;
import com.google.common.eventbus.Subscribe;

import java.util.HashSet;
import CoffeeShopSimulator.Models.States.BaristaStates;

public class Barista extends Person {

    private BaristaStates currentState = BaristaStates.READY; //all baristas start in the inital state
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

    public void setCurrentState(BaristaStates state){ this.currentState = state; }

    public BaristaStates getCurrentState(){ return this.currentState; }

    public void tookOrder(Order o){
        ordersTaken.add(o);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Barista)";
    }
}
