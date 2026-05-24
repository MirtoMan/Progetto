package it.unical.kindled;

import it.unical.kindled.database.DatabaseInitializer;
import it.unical.kindled.database.DatabaseManager;
import it.unical.kindled.view.SceneHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneHandler.init(stage);

        DatabaseInitializer.initialize();
        DatabaseInitializer.createAdminIfNotExists();

        SceneHandler.switchTo("/it/unical/kindled/login-view.fxml", 860, 560);
        stage.setTitle("Kindled!");
    }
}
