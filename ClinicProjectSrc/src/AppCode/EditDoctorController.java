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
import javafx.scene.paint.Color;

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
    @FXML
    private TextField deleteDocID;

    private DoctorQuries doctor = new DoctorQuries();
    private OwnerScreenController owner = new OwnerScreenController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clear(ActionEvent event) {
        docField.clear();
        docName.clear();
        docID.clear();
    }

    @FXML
    private void addDoctor(ActionEvent event) {
        deleteOutputMessage.setTextFill(Color.RED);
        if (docField.getText().isBlank() || docName.getText().isBlank() || docID.getText().isBlank()) {
            addOutPutMessage.setText("Empty TextField Detected ");
        } else if (docName.getText().matches(".*\\d.*")) {
            addOutPutMessage.setText("Name Must Not Contain Numbers");
        } else {
            int result = doctor.addDoctor(Integer.parseInt(docID.getText()), docName.getText(), docField.getText());
            if (result == 1) {
                addOutPutMessage.setTextFill(Color.BLUE);
                addOutPutMessage.setText("Doctr Has Been Added");
            } else {
                addOutPutMessage.setText("Doctr Has Not Been Added");

            }

        }

    }

    @FXML
    private void deleteDoc(ActionEvent event) {
        deleteOutputMessage.setTextFill(Color.RED);
        if (deleteDocID.getText().isBlank()) {
            deleteOutputMessage.setText("Empty ID");
        } else {
            int result = doctor.deleteDoc(Integer.parseInt(deleteDocID.getText()));
            if (result == 1) {
                deleteOutputMessage.setTextFill(Color.BLUE);
                deleteOutputMessage.setText("Doctor Deleted");

            } else {
                deleteOutputMessage.setText("A Error Occured Please Check ID");

            }
        }
    }

}
