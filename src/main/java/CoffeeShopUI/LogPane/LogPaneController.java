package CoffeeShopUI.LogPane;

import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopUI.Shared.BasePaneController;
import javafx.scene.paint.Color;

public class LogPaneController extends BasePaneController {
    public LogPaneController(ICoffeeShop coffeeShop) {
        super(coffeeShop, "/LogPane.fxml", Color.BEIGE, BasePaneController.getScreenHeight(), BasePaneController.getScreenWidth() * 0.2);
    }
}
