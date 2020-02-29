package CoffeeShopSimulator.Models;

public class Barista extends Person {

    private BaristaStates state = BaristaStates.READY; //all baristas start in the inital state

    public Barista(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + "(a Barista)";
    }
}
