import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

package CoffeeShopSimulator.ShopExampleProcedurally;

public class Employee{

    private String name;
    private Queue<String[2]> orders = new LinkedList<>();
    private <String> orderPutOut = new ArrayList<>();

    public Employee(String name){
        this.name = name;
    }

    // take coustomer order
    public void takeOrder(String[2] order){
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
    public void pickup(order){
        orderPutOut.remove(order)
    }

}
