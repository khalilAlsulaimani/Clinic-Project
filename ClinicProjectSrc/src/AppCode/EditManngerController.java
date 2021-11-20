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
    private TextField newUsername;

    @FXML
    private TextField newPassword;

    private ManngerQuries mannger = new ManngerQuries();

    @FXML
    private Label editUsrenameOutputMessage;

    @FXML
    private Label deleteOutputMessage;

    @FXML
    private TextField editUsernameUsername;

    @FXML
    private Label editPasswordOutputMessage;

    @FXML
    private TextField editPasswordUsername;

    @FXML
    private TextField deleteManngerUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void clearAll() {
        fullName.clear();
        username.clear();
        password.clear();
        ManngerID.clear();
        newUsername.clear();
        newPassword.clear();
        editUsernameUsername.clear();
        editPasswordUsername.clear();
        deleteManngerUsername.clear();

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
                clearAll();
            } else {
                addManngerOutputMessage.setText("Mangger Was Not Added Succfully");

            }

        }

    }

    @FXML
    private void clear(ActionEvent event) {
        clearAll();

    }

    @FXML
    private void changeUsername(ActionEvent event) {
        editUsrenameOutputMessage.setTextFill(Color.RED);
        if (newUsername.getText().isBlank() || editUsernameUsername.getText().isBlank()) {
            editUsrenameOutputMessage.setText("Empty TextField Detected");

        } else if (mannger.getMannger(editUsernameUsername.getText()) == null) {
            editUsrenameOutputMessage.setText("Invalid Old Username");

        } else if (newUsername.getText().length() < 3) {
            addManngerOutputMessage.setText("Username must be larger then 3  ");
        } else if (!(newUsername.getText().toLowerCase().startsWith("man"))) {
            editUsrenameOutputMessage.setText("New Username Must Start With 'man'");

        } else {

            int result = mannger.editUsername(editUsernameUsername.getText(), newUsername.getText());
            if (result == 1) {
                editUsrenameOutputMessage.setTextFill(Color.BLUE);
                editUsrenameOutputMessage.setText("Username Was Changed Succfully");
                clearAll();
            } else {
                editUsrenameOutputMessage.setText("Username Was Not Changed Succfully");

            }

        }

    }

    @FXML
    private void changePasword(ActionEvent event) {
        editPasswordOutputMessage.setTextFill(Color.RED);
        if (newPassword.getText().isBlank() || editPasswordUsername.getText().isBlank()) {
            editPasswordOutputMessage.setText("Empty TextField Detected");

        } else if (mannger.getMannger(editPasswordUsername.getText()) == null) {
            editPasswordOutputMessage.setText("Invalid  Username");

        } else if (newPassword.getText().length() < 3) {
            editPasswordOutputMessage.setText("Password must be larger then 3  ");

        } else {

            int result = mannger.editPassword(editPasswordUsername.getText(), newPassword.getText());
            if (result == 1) {
                editPasswordOutputMessage.setTextFill(Color.BLUE);
                editPasswordOutputMessage.setText("Password Was Changed Succfully");
                clearAll();
            } else {
                editPasswordOutputMessage.setText("Password Was Not Changed Succfully");

            }

        }

    }

    @FXML
    private void deleteMannger(ActionEvent event) {
    }

}
