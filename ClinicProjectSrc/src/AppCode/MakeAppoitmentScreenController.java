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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class MakeAppoitmentScreenController implements Initializable {

    @FXML
    private TextField patiantID;
    @FXML
    private ComboBox<Doctor> doctorSelction;
    @FXML
    private DatePicker date;
    @FXML
    private Spinner<Integer> hour;
    @FXML
    private Label outputMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 16);

        valueFactory.setValue(1);

        hour.setValueFactory(valueFactory);

    }

    @FXML
    private void makeAppoitment(ActionEvent event) {
    }

}
