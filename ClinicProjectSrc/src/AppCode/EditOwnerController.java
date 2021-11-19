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

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditOwnerController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField newName;

    private OwnerQuries owner = new OwnerQuries();
    @FXML
    private Label nameOutputMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void changeName(ActionEvent event) {
        if (usernameField.getText().isBlank() || newName.getText().isBlank()) {
            nameOutputMessage.setText("Empty Username Or Name Given Please Enter Correct Values ");
        } else if (owner.getOwner(usernameField.getText()) == null) {
            nameOutputMessage.setText("Invalid Username ");
        } else if (newName.getText().length() < 5 || newName.getText().matches(".*\\.*")) {
            nameOutputMessage.setText("Invalid Name");
        } else {

            int change = owner.editName(usernameField.getText(), newName.getText());

            if (change == 1) {
                nameOutputMessage.setText("Changes Have Been Applied");
                usernameField.clear();
                newName.clear();

            } else {
                nameOutputMessage.setText("Changes Have Not Been Made");
            }

        }

    }

}
