package CoffeeShopSimulator.Utilities;

import java.sql.Timestamp;
import java.util.Date;

public class Logger implements ILogger {
    public static final String WHITE = "\033[0;37m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    /**
     * Logs debugging messages
     *
     * TODO: We want to be able to keep these logs and show them as a stream later on
     * @param message
     */
    @Override
    public void Log(String message) {
        String formattedMessage = addFormattingToMessage(message);
        System.out.println(WHITE + formattedMessage + RESET);
    }

    @Override
    public void LogWarning(String message) {
        String formattedMessage = addFormattingToMessage(message);
        System.out.println(YELLOW + formattedMessage + RESET);
    }

    @Override
    public void LogError(String message, Exception exception) {
        String formattedMessage = addFormattingToMessage(message);
        System.out.println(RED + formattedMessage + RESET);
    }

    private String addFormattingToMessage(String message) {
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        return GREEN + ts + RESET + " " + message;
    }
}
