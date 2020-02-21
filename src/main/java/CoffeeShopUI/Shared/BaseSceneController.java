package CoffeeShopUI.Shared;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class BaseSceneController extends Pane {
    protected final Pane pane = new Pane();

    public BaseSceneController(String resourcePath, Color color) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        loader.setController(this);
        this.pane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    public Pane getPane() {
        return pane;
    }
}
