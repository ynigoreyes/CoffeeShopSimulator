package ShopExampleProcedurally.Data;

import java.util.ArrayList;


public class Employee{

    private String name;
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Order> orderPutOut = new ArrayList<>();
    private int orderCount = 0;

    public Employee(String name){
        this.name = name;
    }

    // take customer order
    public void takeOrder(Guest guest, String order){
        Order newOrder = new Order(guest, order);
        orders.add(newOrder);

        orderCount += 1;
    }

    // make and call order
    public void makeCurrentOrders(){

        while(orders.size() > 0) {
            Order currentOrder = orders.get(0);

            //add order to ___ for pickup
            orderPutOut.add(currentOrder);
            System.out.println("Barista: I have an order for " + currentOrder.getGuest() + ".");
            //remove order from orders
            orders.remove(0);
        }

    }

    // coustomer picks up order and is removed from orderPutOut
    public ArrayList<Order> pickup(Guest g){
        ArrayList<Order> guestOrders = new ArrayList<>();
        for(int i = orderPutOut.size()-1; i >= 0; i--){
            if(orderPutOut.get(0).getGuest().equals(g)){
                guestOrders.add( orderPutOut.remove(i) );
            }
        }

        return guestOrders;
    }

    public int getOrderCount(){
        return orderCount;
    }

    public void resetOrderCount(){
        orderCount = 0;
    }

}
