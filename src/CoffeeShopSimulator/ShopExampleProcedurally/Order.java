package CoffeeShopSimulator.ShopExampleProcedurally;

public class Order {
    Guest guest;
    String order;
    public Order(Guest guest, String order){
        this.guest = guest;
        this.order = order;
    }

    public Guest getGuest(){
        return guest;
    }

    public String getOrder(){
        return order;
    }
}