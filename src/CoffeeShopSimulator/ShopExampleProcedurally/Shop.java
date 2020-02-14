package CoffeeShopSimulator.ShopExampleProcedurally;

import java.util.ArrayList;

public class Shop{

    private Boss manager;
    private Employee barista;
    private ArrayList<Guest> customers;

    public Shop(Boss b, Employee e){
        manager = b;
        barista = e;
        customers = new ArrayList<>();
    }

    public void newCustomerWalksIn(Guest g){
        if(customers.contains(g))
            System.out.println("*This customer is already here*\n");

        customers.add(g);
        System.out.println("Barista: Hello! Welcome to our shop!\n");
    }


}