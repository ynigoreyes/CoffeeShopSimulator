package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.*;
import CoffeeShopSimulator.Exceptions.EventException;
import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Order;
import CoffeeShopSimulator.Utilities.ILogger;
import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a Guava Event Bus wrapper.
 * This was mainly created for abstraction so that
 * if we ever decide to switch event bus providers, we
 * won't have to rewrite as much code
 */

public class CoffeeShopEventBus implements ICoffeeShopEventBus {

    private static CoffeeShopEventBus instance = new CoffeeShopEventBus( new EventBus("ProductionEventBus"), new Logger() );
    private final EventBus eventBus;
    private final ILogger logger;

    private CoffeeShopEventBus(EventBus eventBus, ILogger logger) {
        this.eventBus = eventBus;
        this.logger = logger;
        System.out.println("A CoffeeShopEventBus has been created!\n");
    }

    public static CoffeeShopEventBus getInstance(){
        return instance;
    }

    public void sendEvent(Object e) {
        eventBus.post(e);
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    @Subscribe
    public void handleNewCustomer(NewCustomerWalksInEvent e) {
        logger.Log(e.getCustomer() + " arrived!");
    }

    @Subscribe
    public void handleCustomerGettingInLine(CustomerGetsInLineEvent e) {
        logger.Log(e.getCustomer() + " is getting in line");
    }

    @Subscribe
    public void handleBaristaTakingCustomerOrder(BaristaTakeNextOrderEvent e){
        logger.Log(e.getBarista() + "is taking the next order...");
    }

    @Subscribe
    public void handleBaristaMakeAndServeAllOrders(BaristaMakeAndServeAllOrdersEvent e){
        String logString = e.getBarista() + " made and served the following orders:: \n";
        for(Order o: e.getOrders()){
            logString += "\t" + o + "\t";
        }
        logger.Log(logString);

    }

    @Subscribe
    public void handleCustomerCollectsOrder(CustomerCollectOrderEvent e){
        logger.Log(e.getCustomer() + " is collecting their order");
    }

    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e) {
        logger.Log(e.getCustomer() + " left!");
    }

    @Subscribe
    public void handleManagerChangeMenu(ManagerChangeMenuEvent e){
        logger.Log(e.getManager() + " changed the menu!");
    }

    @Subscribe
    public void handleStateError(EventException e){
        logger.LogError("Something went wrong...", e);
    }

}
