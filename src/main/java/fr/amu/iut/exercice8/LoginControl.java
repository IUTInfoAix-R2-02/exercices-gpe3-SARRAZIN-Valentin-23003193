package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private PasswordField pwd;
    @FXML
    private TextField txt;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;

    @FXML
    private String motCacher;
    @FXML
    private void okClicked() {
        System.out.println("Welcome " + txt.getText());
        for (int i=0; i < pwd.getText().length(); ++i) {
            motCacher += '*';
        }
        System.out.println("Password : " + motCacher);
    }
    @FXML
    private void cancelClicked() {
        txt.clear();
        pwd.clear();
    }
}