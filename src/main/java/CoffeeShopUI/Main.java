package CoffeeShopUI;

import CoffeeShopSimulator.CoffeeShop;
import CoffeeShopSimulator.ICoffeeShop;
import CoffeeShopSimulator.Models.Customer;
import CoffeeShopSimulator.Utilities.Logger;
import CoffeeShopUI.ButtonPane.ButtonPaneController;
import CoffeeShopUI.CoffeeShopPane.CoffeeShopPaneController;
import CoffeeShopUI.LogPane.LogPaneController;
import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private static ICoffeeShop coffeeShop;

    public static void main(String[] args) {
        coffeeShop = new CoffeeShop(eventBus, logger);

        Customer firstCustomer = new Customer("Rajeev");
        coffeeShop.handleAddingPersonToCoffeeShop(firstCustomer);
        coffeeShop.handleCustomerGetOrder(firstCustomer);
        coffeeShop.handleRemovingPersonFromCoffeeShop(firstCustomer);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        BorderPane root = new BorderPane();

        CoffeeShopPaneController coffeeShopPaneController = new CoffeeShopPaneController(coffeeShop);
        LogPaneController logPaneController = new LogPaneController(coffeeShop);
        ButtonPaneController buttonPaneController = new ButtonPaneController(coffeeShop);

        Pane leftPane = logPaneController.getPane();
        Pane middlePane = coffeeShopPaneController.getPane();
        Pane rightPane = buttonPaneController.getPane();

        root.setLeft(leftPane);
        root.setCenter(middlePane);
        root.setRight(rightPane);

        primaryStage.setTitle("Poke Café");
        primaryStage.setScene(new Scene(root));
    }
}
