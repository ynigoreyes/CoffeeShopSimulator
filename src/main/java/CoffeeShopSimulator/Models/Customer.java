package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.Models.States.CustomerStates;

public class Customer extends Person {

    private CustomerStates currentState = CustomerStates.WALKED_IN; //all customers start in initial state

    public Customer(String name) {
        super(name);
        CoffeeShop.addEventToCoffeeShop( new NewCustomerWalksInEvent(this) );
    }

    public void setCurrentState(CustomerStates state){ this.currentState = state; }

    public CustomerStates getCurrentState(){ return this.currentState; }

    @Override
    public String toString(){
        return super.toString() + "(a Customer)";
    }


}
