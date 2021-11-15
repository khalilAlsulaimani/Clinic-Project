/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private OwnerQuries owner = new OwnerQuries();

    private DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private LocalDateTime now = LocalDateTime.now();

    private void failedLogin() {
        errorLabel.setText("Invalid Email Or Password Please Trye again ");
    }

    private void loginLog(String who) {

        try {
            File file = new File("D:\\1-Desktop\\uni\\Year 3\\Advanced Programming Practical\\Clinic Project\\logs\\" + date.format(now) + ".txt");

            FileWriter fileWrite = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fileWrite);
            writer.write(who+": " + " Logged In At " + time.format(now)+"\n---------------------------------\n");
            writer.close();

        } catch (IOException ex) {
            System.out.println("error");
        }

    }

    private void login(String username, String password, ActionEvent event) throws IOException {
        if (username.startsWith("OWN") || username.startsWith("own")) {
            if (owner.login(usernameInput.getText(), passwordInput.getText())) {
                loginLog(username);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OwnerScreen.fxml"));
                ((Node) event.getSource()).getScene().getWindow().hide();

                Parent root = loader.load();
                OwnerScreenController ownerScreen = loader.getController();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("ICare Applications 1.0");
                stage.show();

            } else {
                failedLogin();
            }

        } else if (username.startsWith("MAN") || username.startsWith("man")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManngerScreen.fxml"));
            ((Node) event.getSource()).getScene().getWindow().hide();

            Parent root = loader.load();
            ManngerScreenController manngerScreen = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("ICare Applications 1.0");

            stage.setScene(scene);
            stage.show();
        } else if (username.startsWith("REP") || username.startsWith("rep") ) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReceptionScreen.fxml"));
            ((Node) event.getTarget()).getScene().getWindow().hide();

            Parent root = loader.load();
            ReceptionScreenController receptionScreen = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("ICare Applications 1.0");

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
