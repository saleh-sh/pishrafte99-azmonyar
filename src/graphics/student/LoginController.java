/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.student;


import graphics.launcher.Start;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable {

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
    private TextField txtLoginStudentId;
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

        }

    }

    public void enterButtonAction(ActionEvent event) throws IOException {
        if (txtEnterUsername.getText().isEmpty() || txtEnterPassword.getText().isEmpty()) {
            errorEnterLabel.setVisible(true);
        } else {
            errorEnterLabel.setVisible(false);
            ((Node) event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("MainPage.fxml"));
                BorderPane border = loader.load();

                Start.getBorder().setCenter(border);
                MainPageController userController = (MainPageController) loader.getController();
                userController.getUser(txtEnterUsername.getText());
                //just for test we should add it when we get groups chat from database
                userController.setGroups(new String[]{"گروه اول","گروه دوم"});
        }

    }

    public void numberFieldAction() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
