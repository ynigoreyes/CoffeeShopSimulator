package CoffeeShopSimulator.Models;

public class Customer extends Person {

    private CustomerStates currentState = CustomerStates.WALKED_IN;

    public Customer(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Customer)";
    }
}
