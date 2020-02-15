package CoffeeShopSimulator;

import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;

import CoffeeShopSimulator.ShopExampleProcedurally.*;

public class Main {
    private static final EventBus eventBus = new EventBus("ProductionEventBus");
    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        //CoffeeShop coffeeShop = new CoffeeShop(eventBus, logger);
        //coffeeShop.start();

        Boss manager = new Boss("Miggy");
        Employee barista = new Employee("Rajeev");
        Shop coffeeShop = new Shop(manager, barista);

        Guest aGuest = new Guest("Emily");
        coffeeShop.newCustomerWalksIn(aGuest);
        coffeeShop.customerOrders(aGuest);
        coffeeShop.employeeMakesAllOrders();
        coffeeShop.customerPickUp(aGuest);
        coffeeShop.customerLeaves(aGuest);


    }
}