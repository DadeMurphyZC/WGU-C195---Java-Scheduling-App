/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Utils.DBConnection;
import Utils.SceneObject;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class CustomersController implements Initializable {

    @FXML Button createCustomerBtn, editCustomerBtn;
    @FXML TableView customerTable;
    @FXML TableColumn nameCol, addressCol, phoneCol;
    public static Customer tempEditCustomer = new Customer();

    @FXML
    public static ObservableList customers = FXCollections.observableArrayList();

    @FXML
    public void addCustomer(Event event) throws IOException {
        SceneObject sc = new SceneObject("AddCustomer.fxml");
        sc.loadPopup(createCustomerBtn);
    }
    
    @FXML
    public void editCustomer() throws IOException{
        SceneObject sc = new SceneObject(editCustomerBtn, "EditCustomer.fxml");
        sc.loadPopup(editCustomerBtn);
    }
    
    @FXML
    public void deleteCustomer(){
        
    }
    
    
    
    @FXML
    public void editTest() throws ClassNotFoundException, SQLException, IOException{     
        Customer temp = (Customer)customerTable.getSelectionModel().getSelectedItem();
        tempEditCustomer = DBConnection.searchCustomer(temp.getCustomerName(), temp.getAddressId());
        System.out.println("FROM CUSTOMERSCONTROLLER TEMP: "+tempEditCustomer.getCustomerName());
        SceneObject sc = new SceneObject("EditCustomer.fxml");
        sc.load();
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address1"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        try {
            DBConnection.getCustomers();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DBConnection.customerListDB.forEach((c) -> {
            customers.add(c);
        });
        customerTable.setItems(customers);
    }
}
