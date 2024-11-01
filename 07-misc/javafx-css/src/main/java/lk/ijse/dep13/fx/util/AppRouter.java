package lk.ijse.dep13.fx.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AppRouter {
    public enum Routes{
        MAIN, SECOND
    }

    public static Pane getContainer(Routes route) throws IOException {
        Pane container = null;
        if (route == Routes.MAIN){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/MainScene.fxml"));
        }else if (route == Routes.SECOND){
            container = FXMLLoader.load(AppRouter.class.getResource("/scene/SecondScene.fxml"));
        }
        return container;
    }
}
