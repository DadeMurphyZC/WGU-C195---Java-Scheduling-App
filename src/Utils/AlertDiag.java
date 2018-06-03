/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author cfonseca
 */
public class AlertDiag {
    
    public static void loginError(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Login Error.");
        alert.setHeaderText(null);
        alert.setContentText("Username or Password is incorrect./nPlease try again.");
        alert.showAndWait();
    }


    
}
