package CoffeeShopUI.ButtonPane;

import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopUI.Components.CustomButtonController;
import CoffeeShopUI.Shared.BasePaneController;
import javafx.scene.paint.Color;

public class ButtonPaneController extends BasePaneController {
    public ButtonPaneController(ICoffeeShop coffeeShop) {
        super(coffeeShop,"/ButtonPane.fxml", Color.BLUEVIOLET, BasePaneController.getScreenHeight(), BasePaneController.getScreenWidth() * 0.2);
        CustomButtonController button = new CustomButtonController();
        this.pane.getChildren().add(button.getButton());
    }
}
