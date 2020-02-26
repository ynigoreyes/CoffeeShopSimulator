package CoffeeShopSimulator.Models;

public class Manager extends Person {

    private ManagerStates state = ManagerStates.READY;  //manager will start in initial state

    public Manager(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Manager)";
    }
}
