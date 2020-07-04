
package graphics.student;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class MainPageController implements Initializable {
    
    @FXML
    private Label welcomeLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void getUser(String user){
        welcomeLabel.setText(user);
    }
}
