/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DBConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static Utils.SceneObject.closeScene;
import Model.Customer;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddCustomerController implements Initializable {
    
    @FXML private Button saveBtn;
    @FXML TextField name;
    @FXML TextField address;
    @FXML TextField address2;
    @FXML TextField city;
    @FXML TextField postalCode;
    @FXML TextField phone;
    
    
    
    @FXML 
    public void addCustomer() throws ClassNotFoundException, SQLException{
        Customer c = new Customer(1,name.getText(),1,1);
        DBConnection.addCustomerToDB(c);
        closeScene(saveBtn);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
