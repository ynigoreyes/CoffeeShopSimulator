package CoffeeShopSimulator.Models;

public class Customer extends Person {

    private CustomerStates currentState = CustomerStates.WALKED_IN; //all customers start in initial state

    public Customer(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Customer)";
    }
}
