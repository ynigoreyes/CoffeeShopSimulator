package CoffeeShopSimulator.Models;

public class Manager extends Person {
    public Manager(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Manager)";
    }
}
