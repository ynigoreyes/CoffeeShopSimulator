package CoffeeShopSimulator.Utilities;

import java.sql.Timestamp;
import java.util.Date;

public class Logger implements ILogger {
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
