package CoffeeShopSimulator.Models;

public class Order {
    private String customerName;
    private double cost;
    private String menuItem;

    public double getCost() {
        return cost;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public Order(String customerName, double cost, String menuItem) {
        this.cost = cost;
        this.customerName = customerName;
        this.menuItem = menuItem;
    }
}
