/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Address;
import Utils.DBConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static Utils.SceneObject.closeScene;
import Model.Customer;
import java.sql.Date;
import static java.time.LocalDate.now;
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
        //use TextField input to create a Customer object and add it to the db
        Customer c = new Customer();
        c.setCustomerName(name.getText());
        c.setCreateDate(now());
        c.setCreatedBy("test");
        c.setLastUpdateBy("test");
        c.setAddress(new Address(address.getText(),address2.getText(),1,postalCode.getText(),phone.getText(),Date.valueOf(now()),"test"));
        DBConnection.addCustomerToDB(c);
        //setting the address1, phone values here to update/refresh the TableView
        //only want this for the ui TableView, setAddress1/setPhone are not needed in the db
        c.setAddress1(c.getAddress().getAddress());
        c.setPhone(c.getAddress().getPhone());
        CustomersController.customers.add(c);
        System.out.println(c);
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
