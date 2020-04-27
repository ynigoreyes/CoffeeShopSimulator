package CoffeeShopSimulator.Exceptions;

import javax.print.DocFlavor;

public class EventException extends Exception {

    private String details;

    public EventException(){
        super("An entity was unable to perform the task...");
    }

    public EventException(String details){
        super("An entity was unable to perform the task...\n" + details);
        this.details = details;
    }

    public String toString(){
        return super.toString() + "\n" + details;
    }
}
