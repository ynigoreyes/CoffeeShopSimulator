package CoffeeShopUI.CoffeeShopPane;

import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopUI.Shared.BasePaneController;
import javafx.scene.paint.Color;

public class CoffeeShopPaneController extends BasePaneController {
    public CoffeeShopPaneController(ICoffeeShop coffeeShop) {
        super(coffeeShop,"/CoffeeShopPane.fxml", Color.CRIMSON, BasePaneController.getScreenHeight(), BasePaneController.getScreenWidth() * 0.6);
    }
}
