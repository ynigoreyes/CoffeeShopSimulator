package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.EventBus.Events.*;
import CoffeeShopSimulator.EventBus.ICoffeeShopEventBus;
import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Order;
import CoffeeShopSimulator.Models.Person;
import CoffeeShopSimulator.Utilities.ILogger;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.*;

/**
 * CoffeeShop
 *
 * An entry for interacting with the coffee shop directly.
 * Here, we should be able to add/remove people from the
 * coffee shop and whatever else is needed in the future
 */
public class CoffeeShop implements ICoffeeShop {
    private static ICoffeeShopEventBus coffeeShopEventBus;

    private Queue<Customer> lineToOrder = new LinkedList<Customer>();
    private String[] currentMenu = {"Latte", "Coffee", "Water", "Biscuit", "Croissant"};
    private HashMap<Customer, Order> readyOrders = new HashMap<Customer, Order>();

    /**
     * Creates a Coffee Shop
     *
     * The eventBus is needed so that everyone that is
     * in the coffee shop can listen to each other
     */
    public CoffeeShop(EventBus eventBus, ILogger logger) {
        coffeeShopEventBus = new CoffeeShopEventBus(eventBus, logger);
        eventBus.register(coffeeShopEventBus);
        eventBus.register(this);


        setup();
    }

    public static void addEventToCoffeeShop(CoffeeShopEvent e){
        coffeeShopEventBus.sendEvent(e);
    }

    /**
     * Starts the entire coffee shop doing whatever
     * works needs to be done to get it up and running
     *
     * TODO: Fill in this block comment with what is going to happen to start off the simulation
     */
    private void setup() {
        // Anything for set up can go here
    }

    public void exampleMethodToUseInUI(Object data) {
        System.out.println(data);
    }

    @Subscribe
    public void handleCustomerGetsInLine(CustomerGetsInLineEvent e) {
        Customer customerEnteringLine = e.getCustomer();
        lineToOrder.offer(customerEnteringLine);
    }

    @Subscribe
    public void handleBaristaTakingCustomerOrder(BaristaTakeNextOrderEvent e) {
        Barista barista = e.getBarista();
        Customer customer = lineToOrder.poll();

        String selectedMenuItem = customer.getRandomOrder(currentMenu);
        Order customerOrder = new Order(customer, 20.0, selectedMenuItem);

        barista.tookOrder(customerOrder);
    }

    @Subscribe
    public void handleBaristaMakeAndServeAllOrders(BaristaMakeAndServeAllOrdersEvent e) {
        for(Order o: e.getOrders()){
            readyOrders.put(o.getCustomer(), o);
        }
    }

    @Subscribe void handleCustomerCollectsOrder(CustomerCollectOrderEvent e) {
        readyOrders.remove(e.getCustomer());
    }
}
