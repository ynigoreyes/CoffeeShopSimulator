package CoffeeShopUI.Shared;

import CoffeeShopSimulator.ICoffeeShop;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.awt.*;

public abstract class BasePaneController extends Pane {
    protected final Pane pane = new Pane();
    private ICoffeeShop coffeeShop;

    public BasePaneController(ICoffeeShop coffeeShop, String resourcePath, Color color, double height, double width) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        loader.setController(this);
        this.coffeeShop = coffeeShop;
        this.pane.setBackground(new Background(new BackgroundFill(color, null, null)));
        this.pane.setMinWidth(width);
        this.pane.setMinHeight(height);
    }

    public Pane getPane() {
        return pane;
    }

    public ICoffeeShop getCoffeeShop() { return coffeeShop; }

    protected static double getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }

    protected static double getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }
}
