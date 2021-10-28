/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class LogInScreenController implements Initializable {

    @FXML
    private TextField passwordInput;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField usernameInput;

//    private boolean isValidLogin(String username,String password){
//        
//        
//        
//    }
    private void login(String username, String password, ActionEvent event) throws IOException {
        if (username.startsWith("OWN")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OwnerScreen.fxml"));
            ((Node) event.getSource()).getScene().getWindow().hide();

            Parent root = loader.load();
            ManngerScreenController manngerScreen = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (username.startsWith("MAN")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManngerScreen.fxml"));
            ((Node) event.getSource()).getScene().getWindow().hide();

            Parent root = loader.load();
            ManngerScreenController manngerScreen = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.startsWith("REP")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReceptionScreen.fxml"));
            ((Node) event.getSource()).getScene().getWindow().hide();
            
            Parent root = loader.load();
            ReceptionScreenController manngerScreen = loader.getController();
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            errorLabel.setText("invalid username!");
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signInButton(ActionEvent event) throws IOException {
        errorLabel.setText("");
        if (passwordInput.getText().equals("") && usernameInput.getText().equals("")) {
            errorLabel.setText("No Inputs Given Please Enter Username And Password ");
        } else if (passwordInput.getText().equals("")) {
            errorLabel.setText("Password Not Given , Please Enter Password ");
        } else if (usernameInput.getText().equals("")) {
            errorLabel.setText("Username Not Given , Please Enter Username");
        } else {
            login(usernameInput.getText(), passwordInput.getText(), event);
        }
    }

    @FXML
    private void clearSignIn(ActionEvent event) {
        usernameInput.clear();
        passwordInput.clear();
    }

}
