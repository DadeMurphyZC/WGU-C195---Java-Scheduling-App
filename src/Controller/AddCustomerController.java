/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddCustomerController implements Initializable {

    @FXML
    private Button saveBtn;
    @FXML
    private TextField name, address, address2, city, postalCode, phone;


    @FXML
    public synchronized void addCustomer() throws ClassNotFoundException, SQLException {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
