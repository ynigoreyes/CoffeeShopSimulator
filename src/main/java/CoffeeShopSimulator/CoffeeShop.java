package CoffeeShopSimulator;

import CoffeeShopSimulator.EventBus.CoffeeShopEventBus;
import CoffeeShopSimulator.EventBus.Events.*;
import CoffeeShopSimulator.EventBus.ICoffeeShopEventBus;
import CoffeeShopSimulator.Exceptions.EventException;
import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Order;
import CoffeeShopSimulator.Models.States.CustomerStates;
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
    private HashMap<String, Double> menu;
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
        menu.put("Latte", 5.99);
        menu.put("Coffee", 3.95);
        menu.put("Water", 0.01);
        menu.put("Biscuit", 2.99);
        menu.put("Croissant", 2.99);
    }

    public void exampleMethodToUseInUI(Object data) {
        System.out.println(data);
    }

    @Subscribe
    public void handleCustomerGetsInLine(CustomerGetsInLineEvent e) {
        Customer customerEnteringLine = e.getCustomer();

        if(customerEnteringLine.getCurrentState() == CustomerStates.LEAVE){
            String details = customerEnteringLine + " is not in the Coffee Shop...";
            coffeeShopEventBus.sendEvent( new EventException( details ) );
        }


        if(customerEnteringLine.getCurrentState() == CustomerStates.WALKED_IN) {
            lineToOrder.offer(customerEnteringLine);
            customerEnteringLine.setCurrentState(CustomerStates.IN_LINE);
        }
        else{
            String details = customerEnteringLine + " currently cannot enter into line...";
            coffeeShopEventBus.sendEvent( new EventException( details ) );
        }

    }

    @Subscribe
    public void handleBaristaTakingCustomerOrder(BaristaTakeNextOrderEvent e) {
        Barista barista = e.getBarista();
        Customer customer = lineToOrder.poll();

        while(customer != null && customer.getCurrentState() == CustomerStates.LEAVE){
            customer = lineToOrder.poll();
        }

        if (customer != null){
            if(customer.getCurrentState() == CustomerStates.IN_LINE){
                String selectedMenuItem = customer.getRandomOrder(menu);
                Order customerOrder = new Order(customer, menu.get(selectedMenuItem), selectedMenuItem);
                barista.tookOrder(customerOrder);
                customer.setCurrentState(CustomerStates.WAIT_FOR_ORDER);
            }
            else{
                String details = customer + " cannot order right now...";
                coffeeShopEventBus.sendEvent( new EventException(details) );
            }
        }

        else{
            String details = "There are no customers in line for " + barista + " to take orders for...";
            coffeeShopEventBus.sendEvent( new EventException(details) );
        }
    }

    @Subscribe
    public void handleBaristaMakeAndServeAllOrders(BaristaMakeAndServeAllOrdersEvent e) {
        for(Order o: e.getOrders()){
            readyOrders.put(o.getCustomer(), o);
        }
    }

    @Subscribe
    public void handleCustomerCollectsOrder(CustomerCollectOrderEvent e) {
        Order orderCollected = readyOrders.remove(e.getCustomer());
        if(e.getCustomer().getCurrentState() != CustomerStates.WAIT_FOR_ORDER || orderCollected == null){
            String details = "There is currently no order for " + e.getCustomer() + " to collect...";
            coffeeShopEventBus.sendEvent( new EventException(details) );
        }
        else
            e.getCustomer().setCurrentState(CustomerStates.WALKED_IN);
    }

    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e){
        e.getCustomer().setCurrentState(CustomerStates.LEAVE);
    }

    @Subscribe void handleManagerChangeMenu(ManagerChangeMenuEvent e) {
        menu = e.getNewMenu();
    }

}
