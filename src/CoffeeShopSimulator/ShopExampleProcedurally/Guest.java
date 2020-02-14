package CoffeeShopSimulator.ShopExampleProcedurally;

public class Guest{

    private String name;
    String getName, getReceipt, orderProducts;

    public Guest(String name){
        this.name = name;

        System.out.print("My name for this order is" + getName);
    }
}