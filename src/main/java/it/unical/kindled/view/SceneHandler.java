package it.unical.kindled.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {
    private static Stage primaryStage;
    private static final String CSS = "/it/unical/kindled/css/theme-light.css";

    public static void init(Stage stage) {
        primaryStage = stage;
    }

    public static void switchTo(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(
                    SceneHandler.class.getResource(fxmlPath)
            );
            Scene scene = new Scene(root);
            var css = SceneHandler.class.getResource(CSS);
            if (css != null) {
                scene.getStylesheets().add(css.toExternalForm());
            }

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchTo(String fxmlPath, double width, double height) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneHandler.class.getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height);
            var css = SceneHandler.class.getResource(CSS);
            if (css != null) {
                scene.getStylesheets().add(css.toExternalForm());
            }
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage getStage() {
        return primaryStage;
    }
}
