package CoffeeShopUI;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.Utilities.Logger;
import CoffeeShopUI.CoffeeShopScene.CoffeeShopSceneController;
import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * How to run project using IntelliJ IDEA...
 *
 * 1. Open Maven side bar (look over there --->)
 * 2. Click on the "Execute Maven Goal"
 * 3. Type in "mvn clean javafx:run" without quotes
 * 4. Save run configuration for later
 */
public class Main extends Application {
    private static final EventBus eventBus = new EventBus("ProductionEventBus");
    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(eventBus, logger);
        coffeeShop.start();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.show();
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

        CoffeeShopSceneController coffeeShopSceneController1 = new CoffeeShopSceneController(Color.BEIGE);
        CoffeeShopSceneController coffeeShopSceneController2 = new CoffeeShopSceneController(Color.BLUEVIOLET);
        CoffeeShopSceneController coffeeShopSceneController3 = new CoffeeShopSceneController(Color.CRIMSON);

        Pane leftPane = coffeeShopSceneController1.getPane();
        Pane middlePane = coffeeShopSceneController2.getPane();
        Pane rightPane = coffeeShopSceneController3.getPane();

        root.setLeft(leftPane);
        root.setCenter(middlePane);
        root.setRight(rightPane);

        primaryStage.setTitle("Poke Café");
        primaryStage.setScene(new Scene(root));
    }
}
