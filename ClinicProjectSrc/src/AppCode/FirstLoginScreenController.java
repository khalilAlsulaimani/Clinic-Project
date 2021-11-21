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
public class FirstLoginScreenController implements Initializable {

    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;
    @FXML
    private Label outputMessage;

    private String whoToChange;

    private ManngerQuries mannger = new ManngerQuries();
    private OwnerQuries owner = new OwnerQuries();
    private ReceptionQuries reception = new ReceptionQuries();

    public void getWho(String username) {
        whoToChange = username;
    }

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
    private void changeDefultLogin(ActionEvent event) {

        if (whoToChange.toLowerCase().startsWith("own")) {

            outputMessage.setTextFill(Color.RED);
            if (newUsername.getText().isBlank()) {
                outputMessage.setText("Empty New Password Or new Username Given Please Enter Correct Values ");

            } else if (newUsername.getText().length() < 5 || newPassword.getText().length() < 3) {
                outputMessage.setText("Inputs Are Too Small is Too Small ,Username min is 5 ,Password min is 3");
            } else if (!(newUsername.getText().toLowerCase().startsWith("own"))) {
                outputMessage.setText("Username Must Start With 'own'");
            } else {

                int change1 = owner.editPassword(whoToChange, newPassword.getText());
                int change2 = owner.editUsername(whoToChange, newUsername.getText());

                if (change1 == 1 && change2 == 1) {
                    outputMessage.setTextFill(Color.BLUE);
                    outputMessage.setText("Login Information Has Been Changed");
                    owner.changeisFirstLogin(newUsername.getText());
                    clear(newPassword, newUsername);

                } else {
                    outputMessage.setText("Login Information Has Not Been Chanegd");
                }

            }

        } else if (whoToChange.toLowerCase().startsWith("man")) {
            outputMessage.setTextFill(Color.RED);
            if (newUsername.getText().isBlank()) {
                outputMessage.setText("Empty New Password Or new Username Given Please Enter Correct Values ");

            } else if (newUsername.getText().length() < 5) {
                outputMessage.setText("Inputs Are Too Small is Too Small ,Username min is 5 ,Password min is 3");
            } else if (!(newUsername.getText().toLowerCase().startsWith("man"))) {
                outputMessage.setText("Username Must Start With 'man'");
            } else {

                int change1 = mannger.editPassword(whoToChange, newPassword.getText());
                int change2 = mannger.editUsername(whoToChange, newUsername.getText());

                if (change1 == 1 && change2 == 1) {
                    outputMessage.setTextFill(Color.BLUE);
                    outputMessage.setText("Login Information Has Been Changed");
                    mannger.changeisFirstLogin(newUsername.getText());
                    clear(newPassword, newUsername);

                } else {
                    outputMessage.setText("Login Information Has Not Been Chanegd");
                }
            }

        } else {
             outputMessage.setTextFill(Color.RED);
            if (newUsername.getText().isBlank()) {
                outputMessage.setText("Empty New Password Or new Username Given Please Enter Correct Values ");

            } else if (newUsername.getText().length() < 5) {
                outputMessage.setText("Inputs Are Too Small is Too Small ,Username min is 5 ,Password min is 3");
            } else if (!(newUsername.getText().toLowerCase().startsWith("rep"))) {
                outputMessage.setText("Username Must Start With 'rep'");
            } else {

                int change1 = reception.editPassword(whoToChange, newPassword.getText());
                int change2 = reception.editUsername(whoToChange, newUsername.getText());

                if (change1 == 1 && change2 == 1) {
                    outputMessage.setTextFill(Color.BLUE);
                    outputMessage.setText("Login Information Has Been Changed");
                    reception.changeisFirstLogin(newUsername.getText());
                    clear(newPassword, newUsername);

                } else {
                    outputMessage.setText("Login Information Has Not Been Chanegd");
                }
            }

        }

    }
}
