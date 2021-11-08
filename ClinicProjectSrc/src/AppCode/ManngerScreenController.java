/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.io.IOException;
import java.net.URL;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void editMangs(ActionEvent event) {
    }

    @FXML
    private void editDocs(ActionEvent event) {
    }

    @FXML
    private void editReps(ActionEvent event) {
    }

    
}
