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
public class ManngerScreenController implements Initializable {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label numOfDocs;
    @FXML
    private Label numOfPatiants;
    @FXML
    private Label numOfReceps;
    
    private String manngerUsername;

    private ManngerQuries mannger = new ManngerQuries();
    private DoctorQuries doctor = new DoctorQuries();
    private PatiantQuries patiantt = new PatiantQuries();
    private ReceptionQuries Reception = new ReceptionQuries();

    private DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private LocalDateTime now = LocalDateTime.now();

    public void getManngerUsername(String username) {
        welcomeLabel.setText("Welcome Back " + mannger.getManngerName(username));
        manngerUsername = username;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numOfReceps.setText(String.valueOf(Reception.NumOfReps()));
        numOfPatiants.setText(String.valueOf(patiantt.numOfPatiants()));
        numOfDocs.setText(String.valueOf(doctor.NumOfDoctors()));

    }

    public void refresh() {
        numOfReceps.setText(String.valueOf(Reception.NumOfReps()));
        numOfPatiants.setText(String.valueOf(patiantt.numOfPatiants()));
        numOfDocs.setText(String.valueOf(doctor.NumOfDoctors()));
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        
        File file = new File("D:\\1-Desktop\\uni\\Year 3\\Advanced Programming Practical\\Clinic Project\\logs\\" + date.format(now) + ".txt");

        FileWriter fileWrite = new FileWriter(file, true);
        try (BufferedWriter writer = new BufferedWriter(fileWrite)) {
            writer.write(manngerUsername + ": " + " Logged Out At " + time.format(now) + "\n---------------------------------\n");
        }
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
    private void editDocs(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditDoctor.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Doctors Window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void editReps(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditReceptionest.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Receptionest Window");
        stage.setScene(scene);
        stage.show();
    }

}
