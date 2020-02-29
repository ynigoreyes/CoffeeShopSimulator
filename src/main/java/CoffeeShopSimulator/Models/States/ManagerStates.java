package CoffeeShopSimulator.Models.States;

public enum ManagerStates {

    READY,          //initial state
                    //goes to {PAY_BARISTA, CHANGE_MENU}

    PAY_BARISTA,    //manager pays barista for their work
                    //goes to {READY}

    CHANGE_MENU;    //manager will change the menu
                    //goes to {READY}

}
