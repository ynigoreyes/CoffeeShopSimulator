package CoffeeShopSimulator.EventBus.Events;

/**
 * This is a base Coffee Shop Event
 *
 * You can extend this class how ever much you would like to create new events.
 * This is needed because the `Subscribe` annotations are type sensitive
 */
public abstract class CoffeeShopEvent {
    private final String type;

    public CoffeeShopEvent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
