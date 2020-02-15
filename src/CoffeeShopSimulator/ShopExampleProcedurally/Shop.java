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

    }

    public void customerPickUp(Guest g){

    }

    public void employeeMakesAllOrders(){

    }

    public void employeeServesOrders(){
        
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