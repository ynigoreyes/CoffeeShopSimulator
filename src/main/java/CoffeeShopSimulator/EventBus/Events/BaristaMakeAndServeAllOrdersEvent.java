package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Barista;

public class BaristaMakeAndServeAllOrdersEvent extends CoffeeShopEvent {

    private Barista barista;

    public BaristaMakeAndServeAllOrdersEvent(Barista barista){
        super("BaristaMakeAndServeAllOrdersEvent");
        this.barista = barista;
    }

    public Barista getBarista(){return barista;}
}
