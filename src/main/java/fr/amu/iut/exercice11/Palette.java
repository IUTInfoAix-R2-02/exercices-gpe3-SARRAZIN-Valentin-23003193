package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;


    public int getNbFois() {
        return nbFois.get();
    }

    public void setNbFois(int nbFois) {
        this.nbFois.set(nbFois);
    }

    public IntegerProperty nbFoisProperty() {
        return nbFois;
    }

    private StringProperty message;

    public String getMessage() {
        return message.get();
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public StringProperty messageProperty() {
        return message;
    }

    private StringProperty couleurPanneau;

    public String getCouleurPanneau() {
        return couleurPanneau.get();
    }

    public void setCouleurPanneau(String couleurPanneau) {
        this.couleurPanneau.set(couleurPanneau);
    }

    public StringProperty couleurPanneauProperty() {
        return couleurPanneau;
    }
    private StringProperty couleurTexte;

    public String getCouleurTexte() {
        return couleurTexte.get();
    }

    public StringProperty couleurTexteProperty() {
        return couleurTexte;
    }

    public void setCouleurTexte(String couleurTexte) {
        this.couleurTexte.set(couleurTexte);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        this.nbFois = new SimpleIntegerProperty();
        this.message = new SimpleStringProperty();
        this.couleurPanneau = new SimpleStringProperty("#000000");
        this.couleurTexte = new SimpleStringProperty("#000000");

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            setNbFois(++nbVert);
            setMessage(vert.getText());
            setCouleurPanneau("-fx-background-color: green");
            setCouleurTexte("-fx-text-fill: green");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            setNbFois(++nbRouge);
            setMessage(rouge.getText());
            setCouleurPanneau("-fx-background-color: red");
            setCouleurTexte("-fx-text-fill: red");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            setNbFois(++nbBleu);
            setMessage(bleu.getText());
            setCouleurPanneau("-fx-background-color: blue");
            setCouleurTexte("-fx-text-fill: blue");
        });

        createBindings();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createBindings() {
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(false);
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("Cliquer sur un bouton").otherwise(Bindings.concat(message, " choisi ", nbFois.asString(), " fois")));
        panneau.styleProperty().bind(couleurPanneau);
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).then("").otherwise(Bindings.concat("Le ", message, " est une jolie couleur !")));
        texteDuBas.styleProperty().bind(couleurTexte);
    }
}

