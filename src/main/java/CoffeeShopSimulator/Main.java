package CoffeeShopSimulator;

import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Manager;
import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;

public class Main {
    /**
     * How to run project using IntelliJ IDEA...
     *
     * 1. Open Maven side bar (look over there --->)
     * 2. Click on the "Execute Maven Goal"
     * 3. Type in "mvn clean javafx:run" without quotes
     * 4. Save run configuration for later
     */
    private static final EventBus eventBus = new EventBus("ProductionEventBus");
    private static final Logger logger = new Logger();
    private static ICoffeeShop coffeeShop;

    public static void main(String[] args) {
        coffeeShop = new CoffeeShop(eventBus, logger);

        Manager newManager = new Manager("Emily");

        newManager.changeMenu();
    }
}
