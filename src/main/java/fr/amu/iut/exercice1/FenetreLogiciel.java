package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane cadre = new BorderPane();

        Menu file = new Menu("File");
        MenuItem itemNew = new MenuItem("New");
        MenuItem itemOpen = new MenuItem("Open");
        MenuItem itemSave = new MenuItem("Save");
        MenuItem itemClose = new MenuItem("Close");
        file.getItems().addAll(itemNew, itemOpen, itemSave, itemClose);

        Menu edit = new Menu("Edit");
        MenuItem itemCut = new MenuItem("Cut");
        MenuItem itemCoppy = new MenuItem("Coppy");
        MenuItem itemPaste = new MenuItem("Paste");
        edit.getItems().addAll(itemCut, itemCoppy, itemPaste);

        Menu help = new Menu("help");

        MenuBar barreMenu = new MenuBar(file, edit, help);
        cadre.setTop(barreMenu);

        VBox leftPanel = new VBox();
        leftPanel.getChildren().addAll(new Label("Bouton :"), new Button("Bouton 1"), new Button("Bouton 2"), new Button("Bouton 3"));
        leftPanel.setSpacing(10.0);
        leftPanel.setAlignment(Pos.CENTER);

        Separator vSeparator = new Separator(Orientation.VERTICAL);

        HBox hboxSeparator = new HBox();
        hboxSeparator.getChildren().addAll(leftPanel, vSeparator);
        cadre.setLeft(hboxSeparator);

        VBox centerPanel = new VBox();
        centerPanel.setSpacing(10.0);
        centerPanel.setAlignment(Pos.CENTER);

        GridPane formulaire = new GridPane();
        formulaire.add(new Label("Name:"),0,0);
        formulaire.add(new Label("Email:"),0,1);
        formulaire.add(new Label("Password:"),0,2);
        formulaire.add(new TextField(""),1,0);
        formulaire.add(new TextField(""),1,1);
        formulaire.add(new TextField(""),1,2);
        formulaire.setHgap(10.0);
        formulaire.setVgap(10.0);
        formulaire.setAlignment(Pos.CENTER);

        HBox twoButton = new HBox();
        twoButton.getChildren().addAll(new Button("Submit"), new Button("Cancel"));
        twoButton.setSpacing(10.0);
        twoButton.setAlignment(Pos.CENTER);

        centerPanel.getChildren().addAll(formulaire, twoButton);
        cadre.setCenter(centerPanel);

        HBox bottomPanel = new HBox();
        Label bottomLabel = new Label("Ceci est un label de bas de page");
        bottomPanel.getChildren().add(bottomLabel);
        bottomPanel.setAlignment(Pos.CENTER);

        Separator hseparator = new Separator();

        VBox vboxSeparator = new VBox();
        vboxSeparator.getChildren().addAll(hseparator, bottomPanel);
        cadre.setBottom(vboxSeparator);

        Scene scene1 = new Scene(cadre);
        primaryStage.setScene(scene1);
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

