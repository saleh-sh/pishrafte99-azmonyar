
package graphics.launcher.view;

import graphics.launcher.Start;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainLoginController implements Initializable {

    @FXML
    private Button manageButton;
    @FXML
    private Button studentButton;
    public Stage stage;
    private static Start launcher;
    
    public  void manageButtonAction() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(graphics.manager.LoginControl.class.getResource("Login.fxml"));
        BorderPane manage = loader.load();
        //launcher.getBorderPane().setCenter(manage);
        Stage stage = new Stage();
        stage.setTitle("ورود مدیر");
        stage.setResizable(false);
        stage.getIcons().add(new Image(Start.class
                .getResource("resource/login.png").toString()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(launcher.getStage());
        Scene scene = new Scene(manage);
        stage.setScene(scene);
        stage.showAndWait();
        this.stage = stage;
    }

    public void studentButtonAction() throws IOException{
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
