package CoffeeShopSimulator.Models.States;

public enum BaristaStates {

    READY,      //initial state
                //goes to {TAKE_ORDER, MAKE_ORDER}

    TAKE_ORDER, //takes order of Customer at front of line
                //goes to {READY, TAKE_ORDER}
                //      the reason for going back to TAKE_ORDER is if the barista wants to take all
                //      orders at one time.

    MAKE_ORDER; //makes order that customer is waiting on;
                //goes to {READY, MAKE_ORDER}
                //      the reason for going back to MAKE_ORDER is if the barista wants to make all
                //      orders at one time.

}
