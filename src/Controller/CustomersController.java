/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Utils.SceneObject;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class CustomersController implements Initializable {
    
    @FXML Button createUserBtn;
    
    @FXML public void addCustomer(Event event) throws IOException{
        SceneObject sc = new SceneObject("AddCustomer.fxml");
        sc.loadPopup();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
