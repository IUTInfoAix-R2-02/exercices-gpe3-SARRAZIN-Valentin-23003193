package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    public Node aleatoire (){
        Random random =  new Random();
        int nombre = random.nextInt(3);
        ImageView croix = new ImageView("exercice2/Croix.png");
        ImageView rond = new ImageView("exercice2/Rond.png");
        ImageView vide = new ImageView("exercice2/Vide.png");
        if (nombre == 0){
            return croix;
        }
        else if (nombre == 1){
            return rond;
        }
        else return vide;
    }
    @Override
    public void start(Stage primaryStage) {

        GridPane ticTacToe = new GridPane();
        Label one = new Label("");
        Label two = new Label("");
        Label three = new Label("");
        Label four = new Label("");
        Label five = new Label("");
        Label six = new Label("");
        Label seven = new Label("");
        Label eight = new Label("");
        Label nine = new Label("");

        ticTacToe.add(one,0,0);
        ticTacToe.add(two,1,0);
        ticTacToe.add(three,2,0);
        ticTacToe.add(four,0,1);
        ticTacToe.add(five,1,1);
        ticTacToe.add(six,2,1);
        ticTacToe.add(seven,0,2);
        ticTacToe.add(eight,1,2);
        ticTacToe.add(nine,2,2);
        ticTacToe.setGridLinesVisible(true);

        one.setGraphic(this.aleatoire());
        two.setGraphic(this.aleatoire());
        three.setGraphic(this.aleatoire());
        four.setGraphic(this.aleatoire());
        five.setGraphic(this.aleatoire());
        six.setGraphic(this.aleatoire());
        seven.setGraphic(this.aleatoire());
        eight.setGraphic(this.aleatoire());
        nine.setGraphic(this.aleatoire());

        Scene scene1 = new Scene(ticTacToe);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

