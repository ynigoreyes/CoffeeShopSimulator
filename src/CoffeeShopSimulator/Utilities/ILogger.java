package CoffeeShopSimulator.Utilities;

import java.util.ArrayList;

public interface ILogger {
    /**
     * Logs messages
     * @param message message to print
     */
    void Log(String message);

    /**
     * Logs messages in warning
     * @param message message to print
     */
    void LogWarning(String message);

    /**
     * Logs messages and their error
     * @param message message to print
     */
    void LogError(String message, Exception error);

    /**
     * Gets all of the Log Messages that we have saved so far
     * @return An array of Log Messages to print out
     */
    ArrayList<LogMessage> GetLogs();
}
