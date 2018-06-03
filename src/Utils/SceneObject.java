/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author cfonseca
 */
public class SceneObject {
    static private Stage stage;
    static private Parent root;
    static private Scene scene;
    Button button;
    String file;
    
    //NORMAL CONSTRUCTOR. PASS IN BUTTON AND FILE.
    public SceneObject(Button button, String file) throws IOException{
        stage = (Stage) button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View/"+file));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    };
    
    //POPUP CONSTRUCTOR. ONLY PASS IN FILE, CREATE NEW STAGE OBJECT TO LOAD IN.
    public SceneObject(String file) throws IOException{
        Stage stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/View/"+file));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void load() throws IOException{
        stage.show();
    } 
    
    public void loadPopup() throws IOException{
        stage.show();
    }
}
