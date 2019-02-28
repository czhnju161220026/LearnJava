package nju.czh.Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));
        primaryStage.setTitle("俄罗斯方块");
        Scene scene = new Scene(root,835,755);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("GUI.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String args) {
        launch(args);
    }
}
