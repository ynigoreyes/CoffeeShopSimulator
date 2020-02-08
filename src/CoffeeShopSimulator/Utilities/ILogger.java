package CoffeeShopSimulator.Utilities;

public interface ILogger {
    public void Log(String message);
    public void LogWarning(String message);
    public void LogError(String message);
}
