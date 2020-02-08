package CoffeeShopSimulator;

import com.google.common.eventbus.EventBus;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.start();
    }
}