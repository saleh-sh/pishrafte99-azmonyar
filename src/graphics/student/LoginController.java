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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import logic.RequestCreator;
import logic.user.Student;
import logic.user.UserHandler;

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
                || txtLoginUsername.getText().isEmpty() || txtLoginPassword.getText().isEmpty() || txtLoginStudentId.getText().isEmpty()) {
            errorLoginLabel.setVisible(true);
        } else {
            errorLoginLabel.setVisible(false);

            String firstName = txtLoginname.getText();
            String lastName = txtLoginLastname.getText();
            String username = txtLoginUsername.getText();
            String password = txtLoginPassword.getText();
            String studentId = txtLoginStudentId.getText();

            Student student = new Student(firstName, lastName, password, username, studentId);
            UserHandler.setOnlineUser(student);
            RequestCreator requestCreator = new RequestCreator();
            requestCreator.createStudentSUreq(student);
        }

    }

    public void enterButtonAction(ActionEvent event) throws IOException {
        if (txtEnterUsername.getText().isEmpty() || txtEnterPassword.getText().isEmpty()) {
            errorEnterLabel.setVisible(true);
        } else {
            errorEnterLabel.setVisible(false);
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TopBorder.fxml"));

            Start.setBorder(loader.load());
            Scene scene = new Scene(Start.getBorder());
            Start.getStage().setScene(scene);
            Start.getStage().show();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("MainPage.fxml"));
            BorderPane border = loader1.load();
            Start.getBorder().setCenter(border);
            graphics.student.TopBorderController userController = (graphics.student.TopBorderController) loader.getController();
            userController.getUser(txtEnterUsername.getText());
            graphics.student.MainPageController userController2 = (graphics.student.MainPageController) loader1.getController();
            //just for test we should add it when we get groups chat from database
            userController2.setGroups(new String[]{"گروه اول", "گروه دوم"});
        }

    }

    public void numberFieldAction() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
