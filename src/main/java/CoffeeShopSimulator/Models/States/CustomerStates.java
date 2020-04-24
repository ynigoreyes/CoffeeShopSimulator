package CoffeeShopSimulator.Models.States;

public enum CustomerStates{
    WALKED_IN,      //initial state; goes to {IN_LINE, LEAVE}
    IN_LINE,        //the customer is in line waiting to order; goes to {WAIT_FOR_ORDER, LEAVE}
    WAIT_FOR_ORDER, //has ordered and waiting for it to be made; goes to {WALKED_IN, LEAVE}
                    //NOTE: goes to walked in because once order has been made and collected, they can get in line again
    LEAVE;          //final state where user can be discarded;
}