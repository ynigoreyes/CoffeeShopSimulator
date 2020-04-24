package CoffeeShopSimulator.Models;

public class Order {
    private Customer customer;
    private double cost;
    private String menuItem;

    public double getCost() {
        return cost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public Order(Customer customer, double cost, String menuItem) {
        this.cost = cost;
        this.customer = customer;
        this.menuItem = menuItem;
    }

    public String toString(){
        return String.format("%s\t\t%s\t\t%4.2f", customer.getName(), menuItem, cost);
    }

}
