package CoffeeShopSimulator.Models;

public enum CustomerStates{
    WALKED_IN,      //initial state; goes to {IN_LINE, LEAVE}
    IN_LINE,        //add to line; goes to {READY_TO_ORDER, LEAVE}
    READY_TO_ORDER, //at front of line, waiting for barista; goes to {WAIT_FOR_ORDER, LEAVE}
    WAIT_FOR_ORDER, //has ordered and waiting for it to be made; goes to {GET_ORDER, LEAVE}
    GET_ORDER,      //if order has been made, collect; otherwise go back to wait; goes to {WAIT_FOR_ORDER, DRINK_ORDER, LEAVE}
    DRINK_ORDER,    //user can drink then go back to order; goes to {WALKED_IN, LEAVE}
    LEAVE;          //final state where user can be discarded;
}