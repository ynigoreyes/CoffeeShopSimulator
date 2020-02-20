package CoffeeShopSimulator.Models;

public class Barista extends Person {
    public Barista(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Barista)";
    }
}
