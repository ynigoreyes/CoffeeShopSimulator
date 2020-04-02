package CoffeeShopUI.Components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class CustomButtonController extends Button {
    public CustomButtonController(String buttonText) {
        super(buttonText);
        this.setOnAction(actionEvent -> OnClick());
    }

    public abstract void OnClick();
}
