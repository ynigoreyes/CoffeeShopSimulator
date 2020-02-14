package CoffeeShopSimulator.ShopExampleProcedurally;

import java.util.ArrayList;

public class Shop{

    private Boss manager;
    private Employee barista;
    private ArrayList<Guest> customer;

    public Shop(Boss b, Employee e){
        manager = b;
        barista = e;
        customer = new ArrayList<>();
    }

}