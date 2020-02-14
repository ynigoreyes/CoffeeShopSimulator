package CoffeeShopSimulator.ShopExampleProcedurally;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;


public class Employee{

    private String name;
    private Queue<Order> orders = new LinkedList<>();
    private ArrayList<String> orderPutOut = new ArrayList<>();

    public Employee(String name){
        this.name = name;
    }

    // take customer order
    public void takeOrder(String name, String order){
        Order newOrder = new Order(name, order);
        orders.add(newOrder);
    }

    // make and call order
    public void makeNextOrder(){
        //add order to ___ for pickup
        orderPutOut.add( orders.peek().guestName );

        System.out.println("I have an order for " + orders.peek() );
        //remove order from orders
        orders.remove();
    }

    // coustomer picks up order and is removed from orderPutOut
    public void pickup(Order order){
        orderPutOut.remove(order);
    }

}
