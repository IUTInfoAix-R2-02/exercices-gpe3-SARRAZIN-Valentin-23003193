package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new BorderPane();
        this.label = new Label("");
        this.panneau = new Pane();
        this.bas = new HBox();
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");

        HBox haut = new HBox();
        haut.setAlignment(Pos.CENTER);
        haut.getChildren().add(label);
        root.setTop(haut);

        root.setCenter(panneau);

        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: green");
            label.setText("Vert choisi " + nbVert + " fois");
            this.nbVert += 1;
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: red");
            label.setText("Rouge choisi " + nbRouge + " fois");
            this.nbRouge += 1;
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: blue");
            label.setText("Bleu choisi " + nbBleu + " fois");
            this.nbBleu += 1;
        });

        Scene scene1 = new Scene(root);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
