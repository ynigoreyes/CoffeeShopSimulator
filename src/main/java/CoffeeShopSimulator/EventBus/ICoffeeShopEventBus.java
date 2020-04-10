package CoffeeShopSimulator.EventBus;

import CoffeeShopSimulator.EventBus.Events.CustomerLeavesEvent;
import CoffeeShopSimulator.EventBus.Events.NewCustomerWalksInEvent;
import com.google.common.eventbus.EventBus;

public interface ICoffeeShopEventBus {
    /**
     * Gets the Event Bus instance to (un)register classes manually
     * @return
     */
    EventBus getEventBus();

    /**
     * Sends events for other people in the coffee shop to listen for.
     * Event's will follow an always-once dispatch policy (will only send one time)
     *
     * @param e the event that will be listened to
     */
    void sendEvent(Object e);

}
