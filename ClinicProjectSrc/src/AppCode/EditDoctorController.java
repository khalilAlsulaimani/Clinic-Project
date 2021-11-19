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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditDoctorController implements Initializable {

    @FXML
    private TextField docID;
    @FXML
    private TextField docName;
    @FXML
    private TextField docField;
    @FXML
    private Label addOutPutMessage;
    @FXML
    private Label deleteOutputMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clear(ActionEvent event) {
    }

    @FXML
    private void addDoctor(ActionEvent event) {
    }
    
}
