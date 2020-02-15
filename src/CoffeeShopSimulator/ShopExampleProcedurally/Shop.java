package CoffeeShopSimulator.ShopExampleProcedurally;

import java.util.ArrayList;

public class Shop{

    private Boss manager;
    private Employee barista;
    private ArrayList<Guest> customers;
    private String[] currentMenu;

    public Shop(Boss b, Employee e){
        manager = b;
        barista = e;
        customers = new ArrayList<>();

        currentMenu = manager.NextMenu();
    }

    public void newCustomerWalksIn(Guest g){
        if(customers.contains(g))
            System.out.println("*This customer is already here*\n");

        customers.add(g);
        System.out.println("Barista: Hello! Welcome to our shop!\n");
    }

    public void customerLeaves(Guest g){
        if( !customers.contains(g) )
            System.out.println("*That customer isn't here!*\n");

        System.out.println("Barista: Ok! Goodbye. Have a great day!\n");
    }

    public void customerOrders(Guest g){
        System.out.println("Barista: Can I have a name please?");
        System.out.println(g + ": My name is " + g + ".");
        System.out.println("Barista: What can I get you today?");

        String chosenMenuItem = g.orderMenuItems(currentMenu);
        System.out.println(g + ": Can I get a " + chosenMenuItem + "?");

        barista.takeOrder(g, chosenMenuItem);
        System.out.println("Barista: Certainly! I'll let you know when that's ready.\n");
    }

    public void customerPickUp(Guest g){
        System.out.println(g + ": I'm here for my order.");

        ArrayList<Order> guestOrders = employeeServesOrders(g);
        if(guestOrders.size() > 0){
            System.out.println("Barista: Ah yes! I have the following for you:");
            for(Order o : guestOrders)
                System.out.println("\t" + o.getOrder());
            System.out.println(g + ": Thank you!\n");
        }

        else
            System.out.println("Barista: Sorry... I do not have any orders for you right now.\n");

    }

    public void employeeMakesAllOrders(){
        barista.makeCurrentOrders();
        System.out.println();
    }

    private ArrayList<Order> employeeServesOrders(Guest g){
        return barista.pickup(g);
    }

    public void bossChangesMenu(){
        currentMenu = manager.NextMenu();
    }

    public void bossPaysEmployee(){
        int employeeOrderCount = barista.getOrderCount();
        manager.PayEmployee(employeeOrderCount);
        barista.resetOrderCount();
    }


}