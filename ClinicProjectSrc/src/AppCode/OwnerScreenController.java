/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
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

    private String ownerUsername;

    private DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private LocalDateTime now = LocalDateTime.now();

    private OwnerQuries owner = new OwnerQuries();
    private ReceptionQuries repceptionest = new ReceptionQuries();
    private ManngerQuries mannger = new ManngerQuries();
    private DoctorQuries doctor = new DoctorQuries();
    private PatiantQuries patiant = new PatiantQuries();

    public void getOwnerUsername(String usrname) {
        welcomeLabel.setText("Welcome Back " + owner.getOwnerName(usrname));
        ownerUsername = usrname;

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

        File file = new File("D:\\1-Desktop\\uni\\Year 3\\Advanced Programming Practical\\Clinic Project\\logs\\" + date.format(now) + ".txt");

        FileWriter fileWrite = new FileWriter(file, true);
        try (BufferedWriter writer = new BufferedWriter(fileWrite)) {
            writer.write(ownerUsername + ": " + " Logged Out At " + time.format(now) + "\n---------------------------------\n");
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = loader.load();

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
    private void editMannger(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditMannger.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Mannger Window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void refresh(ActionEvent event) {
        numOfEmployees.setText(String.valueOf(repceptionest.NumOfReps() + mannger.numOfManngers()));
        numOfDoctors.setText(String.valueOf(doctor.NumOfDoctors()));
        numOfPatiance.setText(String.valueOf(patiant.numOfPatiants()));

    }

}
