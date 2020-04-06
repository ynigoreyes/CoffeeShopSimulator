package CoffeeShopSimulator.Models;

public class Order {
    private String customerName;
    private double cost;
    private String order;
    private int orderNumber;

    public double getCost() {
        return cost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrder() {
        return order;
    }

    public Order(String customerName, double cost, int orderNumber, String order) {
        this.cost = cost;
        this.customerName = customerName;
        this.order = order;
        this.orderNumber = orderNumber;
    }
}
