
package graphics.manager;

import graphics.launcher.Start;

import java.io.IOException;

import logic.RequestCreator;
import logic.net.ServerConnection;
import logic.user.Manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import logic.user.UserHandler;
import org.json.simple.JSONObject;

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

    public void loginButtonAction(ActionEvent event) throws IOException {

        if (txtLoginname.getText().isEmpty() || txtLoginLastname.getText().isEmpty()
                || txtLoginUsername.getText().isEmpty() || txtLoginPassword.getText().isEmpty()) {
            errorLoginLabel.setVisible(true);
        } else {
            errorLoginLabel.setVisible(false);

            String firstName = txtLoginname.getText();
            String lastName = txtLoginLastname.getText();
            String userName = txtLoginUsername.getText();
            String password = txtLoginPassword.getText();
            Manager manager = new Manager(firstName, lastName, password, userName);
            UserHandler.setOnlineUser(manager);
            RequestCreator requestCreator = new RequestCreator();
            requestCreator.createManagerSUReq(manager);
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
            graphics.manager.TopBorderController userController = (graphics.manager.TopBorderController) loader.getController();
            userController.getUser(txtEnterUsername.getText());
            MainPageController userController2 = (MainPageController) loader1.getController();
            //just for test we should add it when we get groups chat from database
            userController2.setGroups(new String[]{"گروه اول", "گروه دوم"});
        }

    }

    public void enterButtonAction(ActionEvent event) throws IOException {
        if (txtEnterUsername.getText().isEmpty() || txtEnterPassword.getText().isEmpty()) {
            errorEnterLabel.setVisible(true);
        } else {
            //errorEnterLabel.setVisible(false);
            String username = txtEnterUsername.getText();
            String password = txtEnterPassword.getText();
            Manager manager = new Manager(password, username);
            UserHandler.setOnlineUser(manager);
            RequestCreator requestCreator = new RequestCreator();
            requestCreator.createUserSIreq(manager);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            JSONObject serverFeedback = (JSONObject) ServerConnection.SERVER_CONNECTION.getFeedback();
            if ((Boolean) serverFeedback.get("password") == false || (Boolean) serverFeedback.get("username") == false) {
                errorEnterLabel.setVisible(true);
            } else {
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
                graphics.manager.TopBorderController userController = (graphics.manager.TopBorderController) loader.getController();
                userController.getUser(txtEnterUsername.getText());
                MainPageController userController2 = (MainPageController) loader1.getController();
                //just for test we should add it when we get groups chat from database
                userController2.setGroups(new String[]{"گروه اول", "گروه دوم"});
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
