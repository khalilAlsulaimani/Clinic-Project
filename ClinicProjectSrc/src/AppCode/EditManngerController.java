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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class EditEmployyeController implements Initializable {

    @FXML
    private Label whichEmployeeToBind;
    @FXML
    private TextField fullName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField employeeID;
    @FXML
    private TextField bindID;
    @FXML
    private ComboBox<?> whichEmployee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addEmployee(ActionEvent event) {
    }

    @FXML
    private void editEmplyee(ActionEvent event) {
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
    }
    
}
