package CoffeeShopUI.Components;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class CustomButtonController {
    private Button button = new Button();

    public CustomButtonController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomButton.fxml"));
        loader.setController(this);
        System.out.println("Button Loaded");
    }

    public Button getButton() {
        return button;
    }
}
