package CoffeeShopUI.ButtonPane;

import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopSimulator.Models.Barista;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Models.Manager;
import CoffeeShopSimulator.Models.Person;
import CoffeeShopUI.Components.CustomButton;
import CoffeeShopUI.Shared.BasePaneController;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ButtonPaneController extends BasePaneController {
    private Person focusedPerson;

    public ButtonPaneController(ICoffeeShop coffeeShop) throws Exception {
        super(coffeeShop,"/ButtonPane.fxml", Color.BLUEVIOLET, BasePaneController.getScreenHeight(), BasePaneController.getScreenWidth() * 0.2);

        setNewFocusedUser(new Barista("Rajeev"));
    }

    /**
     * Sets up new buttons
     *
     * Clears out the buttons from the pane
     * Checks what type of Person we are not focusing on and renders specific buttons to match available functionality
     * @param person the person that is currently focused
     */
    public void setNewFocusedUser(Person person) throws Exception {
        ArrayList<CustomButton> listOfButtonsToRender = new ArrayList<>();
        this.pane.getChildren().removeAll();

        if (person instanceof Barista) {
            // Set up the barista buttons depending on what state they are in
            this.renderButtonsForBaristaState(listOfButtonsToRender, person);
        } else if (person instanceof Manager) {
            // Set up the manager buttons depending on what state they are in
            this.renderButtonsForManagerState(listOfButtonsToRender, person);
        } else if (person instanceof Customer) {
            // Set up customer buttons depending on what state they are in
            this.renderButtonsForCustomerState(listOfButtonsToRender, person);
        } else {
            throw new Exception(String.format("Cannot handle type: %s", person));
        }

        listOfButtonsToRender.forEach((button) ->
        {
            this.pane.getChildren().add(button);
        });
    }

    /**
     * Adds a list of buttons to render on the screen
     * when we get a new customer
     * @param listOfButtonsToRender
     * @param person
     */
    private void renderButtonsForCustomerState(ArrayList<CustomButton> listOfButtonsToRender, Person person)
    {
        listOfButtonsToRender.add(new CustomButton("Customer Button") {
            @Override
            public void OnClick() {
                System.out.println("Clicked Customer Button");
            }
        });
    }

    private void renderButtonsForManagerState(ArrayList<CustomButton> listOfButtonsToRender, Person person)
    {
        listOfButtonsToRender.add(new CustomButton("Manager Button") {
            @Override
            public void OnClick() {
                System.out.println("Clicked Manager Button");
            }
        });
    }

    private void renderButtonsForBaristaState(ArrayList<CustomButton> listOfButtonsToRender, Person person)
    {
        listOfButtonsToRender.add(new CustomButton("Barista Button") {
            @Override
            public void OnClick() {
                System.out.println("Clicked Barista Button");
            }
        });
    }
}
