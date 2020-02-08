package CoffeeShopSimulator.Utilities;

import java.sql.Timestamp;
import java.util.Date;

public class Logger implements ILogger {
    /**
     * Logs debugging messages
     *
     * TODO: We want to be able to keep these logs and show them as a stream later on
     * @param message
     */
    @Override
    public void Log(String message) {
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println(ts + " " + message);
    }

    @Override
    public void LogWarning(String message) {

    }

    @Override
    public void LogError(String message) {

    }
}
