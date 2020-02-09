package CoffeeShopSimulator.Utilities;

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
}
