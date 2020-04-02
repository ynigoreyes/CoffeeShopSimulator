package CoffeeShopUI.Components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class CustomButton extends Button {
    public CustomButton(String buttonText) {
        super(buttonText);
        this.setOnAction(actionEvent -> OnClick());
    }

    public abstract void OnClick();
}
