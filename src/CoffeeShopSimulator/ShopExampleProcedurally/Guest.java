package CoffeeShopSimulator.ShopExampleProcedurally;

public class Guest{

    private String name;

    public void Guest(String name) {
        this.name = name;
    }

    public String orderMenuItems(String[] menu){
        String menuItem = menu[ (int)(Math.random()*menu.length) ];

        //customer chooses item(s) off the menu created by the boss
        //menu rotates every certain # of drinks
        System.out.println(name + ": I would like " + menuItem + " please!");
        return menuItem;
    }

    public void ReceiveReceipt(){
        //customer receives receipt from the employee with payment total
        System.out.println(getReceipt + "Thank you!");
    }

    @Override
    public String toString(){
        return name;
    }
}