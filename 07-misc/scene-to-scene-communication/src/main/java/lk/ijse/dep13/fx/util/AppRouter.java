package lk.ijse.dep13.fx.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AppRouter {
    public enum Routes {
        LOGIN, MAIN
    }

    public static FXMLLoader getContainer(Routes route) throws IOException {
        FXMLLoader fxmlLoader = null;
        if (route == Routes.LOGIN){
            fxmlLoader = new FXMLLoader(AppRouter.class.getResource("/scene/LoginScene.fxml"));
        }else if (route == Routes.MAIN){
            fxmlLoader = new FXMLLoader(AppRouter.class.getResource("/scene/MainScene.fxml"));
        }
        return fxmlLoader;
    }
}
