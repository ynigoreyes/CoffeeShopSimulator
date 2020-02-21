package CoffeeShopUI.ButtonPane;

import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopUI.Shared.BasePaneController;
import javafx.scene.paint.Color;

public class ButtonPaneController extends BasePaneController {
    public ButtonPaneController(ICoffeeShop coffeeShop) {
        super(coffeeShop,"/ButtonPane.fxml", Color.BLUEVIOLET, BasePaneController.getScreenHeight(), BasePaneController.getScreenWidth() * 0.2);
    }
}
