/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class ReceptionScreenController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField id;
    @FXML
    private ComboBox<String> doctorsComboBox;

    private DoctorQuries doctor = new DoctorQuries();

    private String repsUsername;
    private PatiantQuries patiance = new PatiantQuries();

    private int selectedDoc;

    private ReceptionQuries reps = new ReceptionQuries();

    private DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private LocalDateTime now = LocalDateTime.now();
    @FXML
    private TextField number;
    @FXML
    private Label outputMessage;

    ObservableList<Doctor> listOfDocs = FXCollections.observableArrayList();

    public void getRepsName(String username) {
        repsUsername = username;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listOfDocs = doctor.getAllDoctors();
        for (int i = 0; i < listOfDocs.size(); i++) {
            doctorsComboBox.getItems().add(listOfDocs.get(i).getFullname());
        }

    }

    public void clear() {
        number.clear();
        age.clear();
        name.clear();
        id.clear();

    }

    @FXML
    private void addPatiant(ActionEvent event) {
        outputMessage.setTextFill(Color.RED);
        if (id.getText().isBlank() || name.getText().isBlank() || age.getText().isBlank() || number.getText().isBlank()) {
            outputMessage.setText("Empty TextField Detected");
        } else if (name.getText().matches(".*\\d.*")) {
            outputMessage.setText("Full-name Cannot Contain  Number");
        } else if (number.getText().length() != 10) {
            outputMessage.setText("Number Must contain 10 numbers");
        } else {
            selectedDoc = doctorsComboBox.getSelectionModel().getSelectedIndex();
            int result = patiance.addPatiant(Integer.parseInt(id.getText()), name.getText(), listOfDocs.get(selectedDoc).getId(),
                    Integer.parseInt(age.getText()), Integer.parseInt(number.getText()));
            if (result == 1) {
                outputMessage.setTextFill(Color.BLUE);
                outputMessage.setText("Patiant Added Succfully");
                clear();

            } else {
                outputMessage.setText("Patiant Wasnt Added Succfully");

            }
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    @FXML
    private void doctorsListButton(ActionEvent event) {

    }

    @FXML
    private void printDoctorsListButton(ActionEvent event) {
        try {
            File file = new File("D:\\1-Desktop\\uni\\Year 3\\Advanced Programming Practical\\Clinic Project\\Prints\\"
                    + date.format(now) + " " + "Doctors Report" + ".txt");

            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWrite);

            for (int i = 0; i < listOfDocs.size(); i++) {
                writer.write("--------------------------------\n");
                writer.write("|                              |\n");
                writer.write("|                              |\n");
                writer.write("|Name: " + listOfDocs.get(i).getFullname() + "\n");
                writer.write("|Field: " + listOfDocs.get(i).getField() + "\n");
                writer.write("|                              |\n");
                writer.write("|                              |\n");
                writer.write("--------------------------------\n");
            }

            writer.close();
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);

        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    @FXML
    private void printAppoitmentsButton(ActionEvent event) {
    }

    @FXML
    private void makeAppoitmentsButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MakeAppoitmentScreen.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("ICare Applications 1.0");

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        File file = new File("D:\\1-Desktop\\uni\\Year 3\\Advanced Programming Practical\\Clinic Project\\logs\\" + date.format(now) + ".txt");

        FileWriter fileWrite = new FileWriter(file, true);
        try ( BufferedWriter writer = new BufferedWriter(fileWrite)) {
            writer.write(repsUsername + ": " + " Logged Out At " + time.format(now) + "\n---------------------------------\n");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = loader.load();
        LogInScreenController LogInScreen = loader.getController();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("ICare Applications 1.0");

        stage.setScene(scene);
        stage.show();
    }

}
