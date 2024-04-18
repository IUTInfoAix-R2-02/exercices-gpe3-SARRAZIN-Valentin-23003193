package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class IHMPendu extends Application {
    private TextField lettreATester;
    private Label nbVie;
    private Dico dico = new Dico();
    String mot = dico.getMot();
    String motCacher = "";
    Label motADeviner;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bP = new BorderPane();
        VBox vbox = new VBox();
        HBox fieldBox = new HBox();

        for (int i=0; i < mot.length(); ++i) {
            motCacher += '*';
        }

        this.lettreATester = new TextField();
        motADeviner = new Label(motCacher);
        this.nbVie = new Label("Nombre de vies : ");

        fieldBox.getChildren().addAll(lettreATester);
        fieldBox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(nbVie, motADeviner, fieldBox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10.0);

        bP.setCenter(vbox);

        Scene scene = new Scene(bP);
        primaryStage.setScene(scene);

        toucheTester();
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        primaryStage.show();
    }
    public String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
    private void toucheTester () {
        lettreATester.setOnAction((ActionEvent event) -> {
            String lettreProposer = lettreATester.getText();
            List<Integer> listePositions = dico.getPositions(lettreProposer.toCharArray()[0], mot);
            for(int i=0; i < mot.length(); ++i) {
                if (listePositions.contains(i)) {
                    motCacher = changeCharInPosition(i, lettreProposer.toCharArray()[0], motCacher);
                }
            }
            lettreATester.clear();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
