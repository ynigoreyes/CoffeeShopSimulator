package CoffeeShopSimulator;

import CoffeeShopSimulator.Models.Person;

public interface ICoffeeShop {
    /**
     * An example method that can be used in the UI
     * @param data anything
     */
    void exampleMethodToUseInUI(Object data);

    /**
     * An example method that adds a person to the Coffee Shop
     * @param person an example person
     */
    void addPeople(Person person);
}
