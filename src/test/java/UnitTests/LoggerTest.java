package UnitTests;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopSimulator.Utilities.ILogger;
import CoffeeShopSimulator.Utilities.LogMessage;
import CoffeeShopSimulator.Utilities.Logger;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class LoggerTest {
    @Test()
    void shouldProperlyAddLogsToTheLogArrayForViewingLater() {
        Logger logger = new Logger();
        String message1 = "Something Cool!";
        String message2 = "Something Better!";
        String message3 = "Something Best!";
        Exception testException = new Exception();

        logger.Log(message1);
        logger.LogWarning(message2);
        logger.LogError(message3, testException);
        ArrayList<LogMessage> logs = logger.GetLogs();

        assertEquals(logs.size(), 3);
        assertEquals(logs.get(0).getMessage(), message1);
        assertEquals(logs.get(1).getMessage(), message2);
        assertEquals(logs.get(2).getMessage(), message3);
    }

    static class CoffeeShopTest {
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
}
