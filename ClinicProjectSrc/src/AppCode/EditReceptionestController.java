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
public class EditReceptionestController implements Initializable {

    @FXML
    private TextField fullName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label addManngerOutputMessage;
    @FXML
    private TextField editUsernameUsername;
    @FXML
    private TextField newUsername;
    @FXML
    private Label editUsrenameOutputMessage;
    @FXML
    private TextField editPasswordUsername;
    @FXML
    private TextField newPassword;
    @FXML
    private Label editPasswordOutputMessage;
    @FXML
    private Label deleteOutputMessage;
    @FXML
    private TextField ReceptionestID;
    
    private ReceptionQuries rep = new ReceptionQuries();
    @FXML
    private TextField deleteReceptionestUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clear(ActionEvent event) {
        clearAll();
    }

    private void clearAll() {
        fullName.clear();
        username.clear();
        password.clear();
        newUsername.clear();
        newPassword.clear();
        editUsernameUsername.clear();
        editPasswordUsername.clear();
        deleteReceptionestUsername.clear();

    }

    @FXML
    private void addReceptionest(ActionEvent event) {
        addManngerOutputMessage.setTextFill(Color.RED);
        if (ReceptionestID.getText().isBlank() || fullName.getText().isBlank() || username.getText().isBlank() || password.getText().isBlank()) {
            addManngerOutputMessage.setText("Empty TextField Detected");
        } else if (fullName.getText().matches(".*\\d.*")) {
            addManngerOutputMessage.setText("Full-name Cannot Contain  Number ");
        } else if (fullName.getText().length() < 3 || username.getText().length() < 3) {
            addManngerOutputMessage.setText("Empty Full-name and username must be larger then 3  ");
        } else if (!username.getText().toLowerCase().startsWith("rep")) {
            addManngerOutputMessage.setText("Username Must Start With 'rep'");

        } else {

            int result = rep.addRecptionest(Integer.parseInt(ReceptionestID.getText()), fullName.getText(), username.getText(), password.getText());
            if (result == 1) {
                addManngerOutputMessage.setTextFill(Color.BLUE);
                addManngerOutputMessage.setText("ReceRptionest Was Added Succfully");
                clearAll();
            } else {
                addManngerOutputMessage.setText("ReceRptionest Was Not Added Succfully");

            }

        }

    }

    @FXML
    private void changeUsername(ActionEvent event) {
        editUsrenameOutputMessage.setTextFill(Color.RED);
        if (newUsername.getText().isBlank() || editUsernameUsername.getText().isBlank()) {
            editUsrenameOutputMessage.setText("Empty TextField Detected");

        } else if (rep.getReceptionist(editUsernameUsername.getText()) == null) {
            editUsrenameOutputMessage.setText("Invalid Old Username");

        } else if (newUsername.getText().length() < 3) {
            addManngerOutputMessage.setText("Username must be larger then 3  ");
        } else if (!(newUsername.getText().toLowerCase().startsWith("rep"))) {
            editUsrenameOutputMessage.setText("New Username Must Start With 'man'");

        } else {

            int result = rep.editUsername(editUsernameUsername.getText(), newUsername.getText());
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

        } else if (rep.getReceptionist(editPasswordUsername.getText()) == null) {
            editPasswordOutputMessage.setText("Invalid  Username");

        } else if (newPassword.getText().length() < 3) {
            editPasswordOutputMessage.setText("Password must be larger then 3  ");

        } else {

            int result = rep.editPassword(editPasswordUsername.getText(), newPassword.getText());
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
    private void deleteReceptionest(ActionEvent event) {
        deleteOutputMessage.setTextFill(Color.RED);
        if (deleteReceptionestUsername.getText().isBlank()) {
            deleteOutputMessage.setText("Empty TextField Detected");

        } else if (rep.getReceptionist(deleteReceptionestUsername.getText()) == null) {
            deleteOutputMessage.setText("Invalid  Username");

        } else {

            int result = rep.deleteReceptionest(deleteReceptionestUsername.getText());
            if (result == 1) {
                deleteOutputMessage.setTextFill(Color.BLUE);
                deleteOutputMessage.setText("Receptionest Was Deleted Succfully");
                clearAll();
            } else {
                deleteOutputMessage.setText("Receptionest Was Not Deleted Succfully");

            }

        }

    }

}
