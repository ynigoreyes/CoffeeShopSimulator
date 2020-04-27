package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Barista;

public class BaristaTakeNextOrderEvent extends CoffeeShopEvent {

    private Barista barista;

    public BaristaTakeNextOrderEvent(Barista barista){
        super("BaristaTakeNextOrderEvent");
        this.barista = barista;
    }

    public Barista getBarista(){return barista;};

}
