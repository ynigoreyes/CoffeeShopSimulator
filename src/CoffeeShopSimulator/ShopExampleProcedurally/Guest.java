package CoffeeShopSimulator.ShopExampleProcedurally;

public class Guest{

    private String name;

    public void Guest(String name) {
        this.name = name;
    }

    public String orderMenuItems(String[] menu){
        //customer chooses item(s) off the menu created by the boss
        String menuItem = menu[ (int)(Math.random()*menu.length) ];

        return menuItem;
    }

    @Override
    public String toString(){
        return name;
    }
}