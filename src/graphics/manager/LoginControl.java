
package graphics.manager;
import logic.user.Manager;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginControl implements Initializable {

    @FXML
    private Label errorLoginLabel;
    @FXML
    private Label sameErrorLoginLabel;
    @FXML
    private Label errorEnterLabel;
    @FXML
    private TextField txtLoginname;
    @FXML
    private TextField txtLoginLastname;
    @FXML
    private TextField txtLoginUsername;
    @FXML
    private PasswordField txtLoginPassword;
    @FXML
    private TextField txtEnterUsername;
    @FXML
    private PasswordField txtEnterPassword;
    @FXML
    private Button loginButton;
    @FXML
    private Button enterButton;

    public void loginButtonAction(ActionEvent event) {

        if (txtLoginname.getText().isEmpty() || txtLoginLastname.getText().isEmpty()
                || txtLoginUsername.getText().isEmpty() || txtLoginPassword.getText().isEmpty()) {
            errorLoginLabel.setVisible(true);
        } else {
            errorLoginLabel.setVisible(false);
             String firstName = txtLoginname.getText();
             String lastName = txtLoginLastname.getText();
             String userName = txtLoginUsername.getText();
             String password = txtLoginPassword.getText();
             Manager manager = new Manager(firstName,lastName,password,userName);
        }

    }

    public void enterButtonAction(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
