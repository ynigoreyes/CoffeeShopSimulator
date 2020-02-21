package CoffeeShopSimulator;

import CoffeeShopSimulator.Utilities.ILogger;
import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeShopTest {
    private ILogger logger;
    private EventBus eventBus;
    private ICoffeeShop coffeeShop;

    @BeforeEach
    void setUp() {
        logger = new Logger();
        eventBus = new EventBus("TestingEventBus");
        coffeeShop = new CoffeeShop(eventBus, logger);
    }

    @Test
    void ExampleTestThatWillFail() {
        assertEquals(true, false);
    }

    @Test
    void ExampleTestThatWillPass() {
        assertEquals(true, true);
    }
}