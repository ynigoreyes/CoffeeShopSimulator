package CoffeeShopSimulator.ShopExampleProcedurally;

public class Guest{

    private String name;
    String getReceipt, menuItem;

    public Guest(String name){
        this.name = name;

        System.out.println("My name for this order is " + name + ".");
        System.out.println("I would like " + menuItem + "please!");
        

    }
}