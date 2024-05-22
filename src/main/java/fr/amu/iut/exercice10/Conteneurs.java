package fr.amu.iut.exercice10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class Conteneurs extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("exercice10/ConteneursView.fxml"));
            stage.setScene(new Scene(root));
            stage.setWidth(900);
            stage.setHeight(600);
            stage.setTitle("Premier exemple manipulant les conteneurs");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}