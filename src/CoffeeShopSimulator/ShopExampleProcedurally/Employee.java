import java.util.LinkedList;
import java.util.Queue;

package CoffeeShopSimulator.ShopExampleProcedurally;

public class Employee{

    private String name;
    private Queue<String[2]> orders = new LinkedList<>();
    private Queue<String> served = new LinkedList<>();

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
        served.add(orders.head);
        //
        System.out.println("I have an order for " + orders.head[0]);
        //remove order from orders
        orders.remove();
    }

}
