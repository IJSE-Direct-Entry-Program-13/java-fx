package lk.ijse.dep13.fx.util;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class AppRouter {
    public static FXMLLoader getContainer(Routes route) throws IOException {
        FXMLLoader fxmlLoader = null;
        if (route == Routes.LOGIN) {
            fxmlLoader = new FXMLLoader(AppRouter.class.getResource("/scene/LoginScene.fxml"));
        } else if (route == Routes.MAIN) {
            fxmlLoader = new FXMLLoader(AppRouter.class.getResource("/scene/MainScene.fxml"));
        }
        return fxmlLoader;
    }

    public enum Routes {
        LOGIN, MAIN
    }
}
