/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditDoctorController implements Initializable {

    @FXML
    private TextField fullName;
    @FXML
    private TextField ID;
    @FXML
    private TextField field;
    @FXML
    private Button addDoc;
    @FXML
    private Button editDoc;
    @FXML
    private Button deleteDoc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
