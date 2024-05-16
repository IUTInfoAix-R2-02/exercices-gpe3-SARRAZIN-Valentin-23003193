package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Label counterLabel;

    @FXML
    private Button decrementButton;

    @FXML
    private Button incrementButton;
    int counter = 0;

    public void increment() {
            counter += 1;
            counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
            counter -= 1;
            counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
