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

    private OwnerQuries owner = new OwnerQuries();
    private ReceptionQuries repceptionest = new ReceptionQuries();
    private ManngerQuries mannger = new ManngerQuries();
    private DoctorQuries doctor = new DoctorQuries();
    private PatiantQuries patiant = new PatiantQuries();

    public void getOwnerUsername(String usrname) {
        welcomeLabel.setText("Welcome Back " + owner.getOwnerName(usrname));

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numOfEmployees.setText(String.valueOf(repceptionest.NumOfReps() + mannger.numOfManngers()));
        numOfDoctors.setText(String.valueOf(doctor.NumOfDoctors()));
        numOfPatiance.setText(String.valueOf(patiant.numOfPatiants()));

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
