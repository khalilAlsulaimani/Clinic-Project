/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditOwnerController implements Initializable {

    @FXML
    private TextField newName;

    private OwnerQuries owner = new OwnerQuries();
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;

    @FXML
    private Label nameOutPutMessage;
    @FXML
    private Label usernameOutPutMessage;
    @FXML
    private Label passwordOutPutMessage;
    @FXML
    private TextField usernameFieldOnNamePage;
    @FXML
    private TextField usernameFieldOnUsernamePage;
    @FXML
    private TextField usernameFieldOnPasswordPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void clear(TextField text1, TextField text2) {
        text1.clear();
        text2.clear();

    }

    @FXML
    private void changeName(ActionEvent event) {
        nameOutPutMessage.setTextFill(Color.RED);
        if (usernameFieldOnNamePage.getText().isBlank() || newName.getText().isBlank()) {
            nameOutPutMessage.setText("Empty Username Or Name Given Please Enter Correct Values ");
        } else if (owner.getOwner(usernameFieldOnNamePage.getText()) == null) {
            nameOutPutMessage.setText("Invalid Username ");
        } else if (newName.getText().length() < 5 || newName.getText().matches(".*\\d.*")) {
            nameOutPutMessage.setText("Invalid Name");
        } else {

            int change = owner.editName(usernameFieldOnNamePage.getText(), newName.getText());

            if (change == 1) {
                nameOutPutMessage.setTextFill(Color.BLUE);
                nameOutPutMessage.setText("Name Has Been Changed");
                clear(usernameFieldOnNamePage, newName);

            } else {
                nameOutPutMessage.setText("Name Has Not Been Changed Error Occured");
            }

        }

    }

    @FXML
    private void changeUsername(ActionEvent event) {
        usernameOutPutMessage.setTextFill(Color.RED);
        if (usernameFieldOnUsernamePage.getText().isBlank() || newUsername.getText().isBlank()) {
            usernameOutPutMessage.setText("Empty Username Or new Username Given Please Enter Correct Values ");
        } else if (owner.getOwner(usernameFieldOnUsernamePage.getText()) == null) {
            usernameOutPutMessage.setText("Invalid Old Username");
        } else if (newUsername.getText().length() < 5) {
            usernameOutPutMessage.setText("New Username is Too short");
        } else if (newUsername.getText().startsWith("OWN", 2)) {
            usernameOutPutMessage.setText("Username Must Start With own");
        } else {

            int change = owner.editUsername(usernameFieldOnUsernamePage.getText(), newUsername.getText());

            if (change == 1) {
                usernameOutPutMessage.setTextFill(Color.BLUE);
                usernameOutPutMessage.setText("Username Has Been Changed");
                clear(usernameFieldOnUsernamePage, newUsername);

            } else {
                usernameOutPutMessage.setText("Username Has Not Been Chanegd");
            }

        }
    }

    @FXML
    private void changePassword(ActionEvent event) {
        passwordOutPutMessage.setTextFill(Color.RED);
        if (usernameFieldOnPasswordPage.getText().isBlank() || newPassword.getText().isBlank()) {
            passwordOutPutMessage.setText("Empty Password Or new Username Given Please Enter Correct Values ");
        } else if (owner.getOwner(usernameFieldOnPasswordPage.getText()) == null) {
            passwordOutPutMessage.setText("Invalid Username");
        } else if (newPassword.getText().length() < 5) {
            passwordOutPutMessage.setText("Password is Too short");
        } else {

            int change = owner.editPassword(usernameFieldOnPasswordPage.getText(), newPassword.getText());

            if (change == 1) {
                passwordOutPutMessage.setTextFill(Color.BLUE);
                passwordOutPutMessage.setText("password Has Been Changed");
                clear(usernameFieldOnPasswordPage, newPassword);

            } else {
                passwordOutPutMessage.setText("Password Has Not Been Chanegd");
            }

        }
    }

}
