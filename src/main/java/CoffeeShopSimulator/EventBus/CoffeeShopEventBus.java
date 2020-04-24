package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.*;
import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Order;
import CoffeeShopSimulator.Utilities.ILogger;
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
    private final EventBus eventBus;
    private final ILogger logger;

    public CoffeeShopEventBus(EventBus eventBus, ILogger logger) {
        this.eventBus = eventBus;
        this.logger = logger;
        System.out.println("A CoffeeShopEventBus has been created!\n");
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
        logger.Log(e.getCustomer() + " Got in line");
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
        logger.Log(e.getCustomer() + " collected their order");
    }

    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e) {
        logger.Log(e.getCustomer() + " left!");
    }

}
