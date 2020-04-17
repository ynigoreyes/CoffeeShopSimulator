package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.CustomerInLineEvent;
import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Person;
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

    private Queue<Customer> lineToOrder = new LinkedList<Customer>();

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
        this.eventBus.register(e.getCustomer());
    }

    @Subscribe
    public void handleCustomerLeaving(CustomerLeavesEvent e) {
        logger.Log(e.getCustomer() + " left!");
        this.eventBus.unregister(e.getCustomer());
    }

    @Subscribe
    public void handleCustomerGettingInLine(CustomerInLineEvent e) {
        logger.Log(e.getCustomer() + " Got in line");
        lineToOrder.add((e.getCustomer()));
    }

}
