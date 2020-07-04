package graphics.launcher;


import graphics.launcher.view.Animationed;
import java.io.IOException;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.RequestCreator;
import logic.net.Client;
import org.json.simple.JSONObject;


public class Start extends Application {
    private static Stage stage;
    private static BorderPane border;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        getStage().setTitle("سیستم آزمون یار");
        getStage().setResizable(false);
        getStage().getIcons().add(new Image(getClass()
                .getResource("resource/logo.png").toString()));
        showLoginPage();
        showLoginItems();
        Animationed animation = new Animationed(50, border, 0.1);
        animation.generateAnimation();
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

        Client client = new Client();
        RequestCreator.setClient(client);
        new Thread(client).start();

        launch(args);

/*
        C c = new C("saleh", "6789", "shie", "ghghg");
        JSONObject object = new JSONObject();
        object.put("username", c.username);
        object.put("password", c.password);
        object.put("firstName", c.firstName);
        object.put("lastName", c.lastName);
        object.put("code", new Integer(111));
*/
        //client.setObject(object);

        //new Thread(client).start();
    }


    public static Stage getStage() {
        return stage;
    }

    public static BorderPane getBorder() {
        return border;
    }

}

class C {
    String username;
    String password;
    String firstName;
    String lastName;

    public C(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
