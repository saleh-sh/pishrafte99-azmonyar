package graphics.launcher;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Start extends Application{
    private  static Stage stage;
    private  BorderPane border;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        getStage().setTitle("سیستم آزمون یار");
        getStage().setResizable(false);
        getStage().getIcons().add(new Image(getClass()
                .getResource("resource/logo.png").toString()));
        showLoginPage();
        showLoginItems();
    }
    public void showLoginItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/MainLogin.fxml"));
        BorderPane borderPane = loader.load();
        getBorder().setCenter(borderPane);
    }

    public void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/EmptyPage.fxml"));
        border = loader.load();
        Scene scene = new Scene(getBorder());
        getStage().setScene(scene);
        getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static Stage getStage() {
        return stage;
    }

    public  BorderPane getBorder() {
        return border;
    }
    
}
