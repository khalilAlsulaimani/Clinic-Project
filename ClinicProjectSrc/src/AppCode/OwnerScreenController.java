/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class OwnerScreenController implements Initializable {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label numOfPatiance;
    @FXML
    private Label numOfDoctors;
    @FXML
    private Label numOfEmployees;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @throws java.sql.SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DatabaseConnection connection = new DatabaseConnection();

            welcomeLabel.setText(connection.getName("OWNER", 1));

            numOfPatiance.setText(String.valueOf(connection.getNumOfColumns("PAITIANT")));

            numOfDoctors.setText(String.valueOf(connection.getNumOfColumns("DOCTOR")));

            numOfEmployees.setText(String.valueOf(connection.getNumOfColumns("DOCTOR")));

        } catch (SQLException ex) {
            Logger.getLogger(OwnerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = loader.load();
        LogInScreenController scene2contr = loader.getController();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ICare Applications 1.0");
        stage.show();

    }

    @FXML
    private void editOwner(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditOwner.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Owners Window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void editDoctor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditDoctor.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Doctors Window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void editEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditEmployye.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Employee Window");
        stage.setScene(scene);
        stage.show();
    }

}
