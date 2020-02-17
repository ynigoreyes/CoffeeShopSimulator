package CoffeeShopSimulator;

import CoffeeShopSimulator.Utilities.Logger;
import ShopExampleProcedurally.Data.Boss;
import ShopExampleProcedurally.Data.Employee;
import ShopExampleProcedurally.Data.Guest;
import ShopExampleProcedurally.Data.Shop;
import com.google.common.eventbus.EventBus;

public class Main {
    private static final EventBus eventBus = new EventBus("ProductionEventBus");
    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(eventBus, logger);
        coffeeShop.start();
    }
}