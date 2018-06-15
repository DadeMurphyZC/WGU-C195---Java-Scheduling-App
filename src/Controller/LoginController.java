/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utils.DBConnection;
import Utils.SceneObject;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class LoginController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Label error1;
    @FXML
    private Label error2;

    @FXML
    public void login(Event event) throws ClassNotFoundException, SQLException, IOException {
        if (DBConnection.loginAuth(user.getText(), pass.getText()) == true) {
            SceneObject sc = new SceneObject(loginButton,"Dashboard.fxml");
            sc.load();
        } else {
            error1.setVisible(true);
            error2.setVisible(true);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
