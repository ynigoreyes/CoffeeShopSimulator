package CoffeeShopSimulator.Utilities;

import java.sql.Timestamp;

public class LogMessage {
    private Timestamp timestamp;
    private String message;

    public LogMessage(Timestamp timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
