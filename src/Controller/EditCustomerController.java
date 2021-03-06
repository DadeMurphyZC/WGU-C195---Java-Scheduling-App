/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.CustomersController.tempEditCustomer;
import Model.Address;
import Model.Customer;
import Utils.DBConnection;
import static Utils.SceneObject.closeScene;
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
 * @author cris
 */
public class EditCustomerController implements Initializable {
    
    @FXML Button saveBtn;
    @FXML TextField name, address, address2, city, postalCode, phone;
    
    @FXML
    public void editCustomer() throws ClassNotFoundException, SQLException {
        //use TextField input to create a Customer object and add it to the db
        Customer c = new Customer();
        c.setCustomerName(name.getText());
        c.setAddress(new Address(address.getText(),address2.getText(),1,postalCode.getText(),phone.getText()));
        c.setAddress1(c.getAddress().getAddress());
        c.setPhone(c.getAddress().getPhone());
        DBConnection.addCustomerToDB(c);
        System.out.println(c);
        closeScene(saveBtn);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(tempEditCustomer.getCustomerName());
        address.setText(tempEditCustomer.getAddress1());
        city.setText(Integer.toString(tempEditCustomer.getAddress().getCityId()));
        postalCode.setText(tempEditCustomer.getAddress().getPostalCode());
        phone.setText(tempEditCustomer.getAddress().getPhone());
    }    
    
}
