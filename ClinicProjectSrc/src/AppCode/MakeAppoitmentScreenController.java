/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.net.URL;
import java.time.Instant;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class MakeAppoitmentScreenController implements Initializable {

    @FXML
    private TextField patiantID;
    @FXML
    private ComboBox<String> doctorSelction;
    @FXML
    private DatePicker date;
    @FXML
    private Spinner<Integer> hour;
    @FXML
    private Label outputMessage;

    private PatiantQuries patiant = new PatiantQuries();
    private int selectedDoc;

    private DoctorQuries doctor = new DoctorQuries();

    private AppoitmentQuary appoitmnet = new AppoitmentQuary();
    ObservableList<Doctor> listOfDocs = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listOfDocs = doctor.getAllDoctors();
        for (int i = 0; i < listOfDocs.size(); i++) {
            doctorSelction.getItems().add(listOfDocs.get(i).getFullname());
        }

        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 16);

        valueFactory.setValue(1);

        hour.setValueFactory(valueFactory);

    }

    @FXML
    private void makeAppoitment(ActionEvent event) {
        outputMessage.setTextFill(Color.RED);
        if (date.getValue().equals(null) || patiantID.getText().isBlank() || doctorSelction.getSelectionModel().isEmpty()) {
            outputMessage.setText("Empty TextField Detected");
        } else if (patiant.getPatiant(Integer.parseInt(patiantID.getText())) == null) {
            outputMessage.setText("Patiant ID Is Incorrect");
        } else {
            Date gettedDatePickerDate = Date.valueOf(date.getValue());
            Patiant thePatiant = patiant.getPatiant(Integer.parseInt(patiantID.getText()));
            selectedDoc = doctorSelction.getSelectionModel().getSelectedIndex();
            int result = appoitmnet.bookAppoitment(hour.getValue(), gettedDatePickerDate, Integer.parseInt(patiantID.getText()), thePatiant.getFullName(),
                    listOfDocs.get(selectedDoc).getId(), doctorSelction.getSelectionModel().getSelectedItem());
            if (result == 1) {
                outputMessage.setTextFill(Color.BLUE);
                outputMessage.setText("Appoitment Succfully Booked");
            } else {
                outputMessage.setText("Appoitment Wasn't Booked Error Occured");
            }
        }

    }

}
