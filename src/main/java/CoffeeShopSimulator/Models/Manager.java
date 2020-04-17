package CoffeeShopSimulator.Models;

import CoffeeShopSimulator.Models.States.ManagerStates;

public class Manager extends Person {

    private ManagerStates currentState = ManagerStates.READY;  //manager will start in initial state

    public Manager(String name) {
        super(name);
    }

    public void setCurrentState(ManagerStates state){ this.currentState = state; }

    public ManagerStates getCurrentState(){ return this.currentState; }

    @Override
    public String toString(){
        return super.toString() + "(a Manager)";
    }
}
