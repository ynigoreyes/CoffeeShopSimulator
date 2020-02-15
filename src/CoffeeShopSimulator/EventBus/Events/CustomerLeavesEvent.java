package CoffeeShopSimulator.EventBus.Events;

import CoffeeShopSimulator.Models.Customer;

/**
 * Event for when customers walk out of the coffee shop
 */
public class CustomerLeavesEvent extends CoffeeShopEvent {
    private Customer customer;

    public CustomerLeavesEvent(Customer customer) {
        super("CustomerLeaves");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * This is an abstracted method from the CoffeeShopEvent class.
     * This is to validate the Event that occurs has a valid Customer
     *      passed to this object.
     *
     * @param data Object to be validated
     * @return If the data passed is not null and is an instance of Customer
     */
    public boolean validateEvent(Object... data){

        for(Object o : data){
            if (o == null){
                System.out.println("A Customer cannot be null!!!");
                return false;
            }

            else if( !(o instanceof Customer) ){
                System.out.println("All data must be a Customer!!!");
                return false;
            }
        }

        return true;
    }
}
