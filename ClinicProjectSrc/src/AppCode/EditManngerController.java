/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditManngerController implements Initializable {

    @FXML
    private TextField fullName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField ManngerID;
    @FXML
    private Label addManngerOutputMessage;
    @FXML
    private TextField editUsernameID;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField editPasswordID;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField deleteManngerID;

    private ManngerQuries mannger = new ManngerQuries();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addMannger(ActionEvent event) {
        addManngerOutputMessage.setTextFill(Color.RED);
        if (ManngerID.getText().isBlank() || fullName.getText().isBlank() || username.getText().isBlank() || password.getText().isBlank()) {
            addManngerOutputMessage.setText("Empty TextField Detected");
        } else if (fullName.getText().matches(".*\\d.*")) {
            addManngerOutputMessage.setText("Full-name Cannot Contain  Number ");
        } else if (fullName.getText().length() < 3 || username.getText().length() < 3) {
            addManngerOutputMessage.setText("Empty Full-name and username must be larger then 3  ");
        } else if (!username.getText().toLowerCase().startsWith("man")) {
            addManngerOutputMessage.setText("Username Must Start With 'man'");

        } else {

            int result = mannger.addMannger(Integer.parseInt(ManngerID.getText()), fullName.getText(), username.getText(), password.getText());
            if (result == 1) {
                addManngerOutputMessage.setTextFill(Color.BLUE);
                addManngerOutputMessage.setText("Mangger Was Added Succfully");
                clear(event);
            } else {
                addManngerOutputMessage.setText("Mangger Was Not Added Succfully");

            }

        }

    }

    @FXML
    private void clear(ActionEvent event) {
        ManngerID.clear();
        fullName.clear();
        username.clear();
        password.clear();
    }

    @FXML
    private void changeUsername(ActionEvent event) {
    }

    @FXML
    private void changePasword(ActionEvent event) {
    }

    @FXML
    private void deleteMannger(ActionEvent event) {
    }

}
