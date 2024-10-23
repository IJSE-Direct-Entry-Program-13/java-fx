package lk.ijse.dep13.fx.util;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

public class AppRouter {

    public enum Routes {
        MAIN, MANAGE_CUSTOMER, PLACE_ORDER, MANAGE_STOCK, CONFIGURE_SETTINGS
    }

    public static AnchorPane getContainer(Routes route) throws IOException {
        AnchorPane container = null;
        if (route == Routes.MAIN){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/MainScene.fxml"));
        }else if (route == Routes.MANAGE_CUSTOMER){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/ManageCustomerScene.fxml"));
        }else if (route == Routes.PLACE_ORDER){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/PlaceOrderScene.fxml"));
        }else if (route == Routes.MANAGE_STOCK){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/ManageStockScene.fxml"));
        }else if(route == Routes.CONFIGURE_SETTINGS) {
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/ConfigureSettingsScene.fxml"));
        }
        FadeTransition ft = new FadeTransition(Duration.millis(700), container);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
        return container;
    }

}
