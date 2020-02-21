package CoffeeShopUI.CoffeeShopScene;

import CoffeeShopUI.Shared.BaseSceneController;
import javafx.scene.paint.Color;

public class CoffeeShopSceneController extends BaseSceneController {
    public CoffeeShopSceneController(Color color) {
        super("/CoffeeShopScene.fxml", color);

        this.getPane().setMinHeight(100);
        this.getPane().setMinWidth(300);
    }
}
