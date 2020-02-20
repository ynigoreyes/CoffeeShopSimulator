package CoffeeShopSimulator.Utilities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Logger implements ILogger {
    private static final String WHITE = "\033[0;37m";
    private static final String GREEN = "\033[0;32m";
    private static final String YELLOW = "\033[0;33m";
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    private ArrayList<LogMessage> logs;

    public Logger() {
        this.logs = new ArrayList<>();
    }

    /**
     * Logs debugging messages
     * @param message
     */
    @Override
    public void Log(String message) {
        String formattedMessage = addFormattingToMessage(message);
        this.addToLogs(message);
        System.out.println(WHITE + formattedMessage + RESET);
    }

    @Override
    public void LogWarning(String message) {
        String formattedMessage = addFormattingToMessage(message);
        this.addToLogs(message);
        System.out.println(YELLOW + formattedMessage + RESET);
    }

    @Override
    public void LogError(String message, Exception exception) {
        String formattedMessage = addFormattingToMessage(message);
        this.addToLogs(message);
        System.out.println(RED + formattedMessage + RESET);
    }

    @Override
    public ArrayList<LogMessage> GetLogs() {
        return this.logs;
    }

    private String addFormattingToMessage(String message) {
        Timestamp ts = getCurrentTime();

        return GREEN + ts + RESET + " " + message;
    }

    private Timestamp getCurrentTime() {
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        return ts;
    }

    private void addToLogs(String message) {
        Timestamp ts = getCurrentTime();
        LogMessage logMessage = new LogMessage(ts, message);
        this.logs.add(logMessage);
    }
}
