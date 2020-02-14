package CoffeeShopSimulator.ShopExampleProcedurally;

import java.util.Scanner;

public class Guest{

    private String name, getReceipt, menuItem;

    public void Guest(String name, Scanner input) {
        this.name = name;

        input.nextLine();
        //customer gives their name to the employee for the order
        //customer name can be called when the order is made by employee
        System.out.println("My name for this order is" + name + ".");
    }

    public void orderMenuItems(Scanner input){

        input.nextLine();
        //customer chooses item(s) off the menu created by the boss
        //menu rotates every certain # of drinks
        System.out.println("I would like " + menuItem + "please!");
    }

    public void ReceiveReceipt(Scanner input){

        input.nextLine();
        //customer receives receipt from the employee with payment total
        System.out.println(getReceipt + "Thank you!");
    }
}