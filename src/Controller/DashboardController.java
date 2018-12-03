/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Utils.SceneObject;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class DashboardController implements Initializable {

    @FXML private Button userBtn;
    @FXML private Button appointmentBtn;
    @FXML private Button calendarBtn;
    @FXML private Button reportsBtn;
    
    @FXML
    public void userMenu() throws IOException{
//        SceneObject sc = new SceneObject(userBtn, "Customers.fxml");
//        sc.load();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
