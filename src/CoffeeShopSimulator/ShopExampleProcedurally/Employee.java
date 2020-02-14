import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

package CoffeeShopSimulator.ShopExampleProcedurally;

public class Employee{

    public class Order {
        String guestName;
        String order;
        public Order(String name, String order){
            guestName = name;
            order = order;
        }
    }

    private String name;
    private Queue<Order> orders = new LinkedList<>();
    private <String> orderPutOut = new ArrayList<>();

    public Employee(String name){
        this.name = name;
    }

    // take coustomer order
    public void takeOrder(Order order){
        //order is an array of size 2 the first element is the coustomer name the 2nd is their order
        orders.add(order);
    }

    // make and call order
    public void makeNextOrder(){
        //add order to ___ for pickup
        orderPutOut.add(orders.head);
        //
        System.out.println("I have an order for " + orders.head[0]);
        //remove order from orders
        orders.remove();
    }

    // coustomer picks up order and is removed from orderPutOut
    public void pickup(Order order){
        orderPutOut.remove(order);
    }

}
