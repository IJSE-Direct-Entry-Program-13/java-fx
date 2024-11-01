package lk.ijse.dep13.fx.util;

import javafx.fxml.FXMLLoader;

public class AppRouter {

    public enum Routes{
        MAIN, UTILITY
    }

    public static FXMLLoader getContainer(Routes route){
        FXMLLoader loader = null;
        if (route == Routes.MAIN){
            loader = new FXMLLoader(AppRouter.class.getResource("/scene/MainScene.fxml"));
        } else if (route == Routes.UTILITY) {
            loader = new FXMLLoader(AppRouter.class.getResource("/scene/UtilityScene.fxml"));
        }
        return loader;
    }
}
