package lk.ijse.dep13.fx.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AppRouter {
    public enum Routes {
        MAIN, USER_INTERFACE1, USER_INTERFACE2, USER_INTERFACE3
    }

    public static AnchorPane getContainer(Routes route) throws IOException {
        AnchorPane container = null;
        if (route == Routes.MAIN){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/MainScene.fxml"));
        } else if (route == Routes.USER_INTERFACE1) {
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/UserInterface1Scene.fxml"));
        } else if (route == Routes.USER_INTERFACE2) {
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/UserInterface2Scene.fxml"));
        } else if (route == Routes.USER_INTERFACE3) {
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/UserInterface3Scene.fxml"));
        }
        return container;
    }
}
