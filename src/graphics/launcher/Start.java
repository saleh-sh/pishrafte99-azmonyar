package graphics.launcher;


import graphics.launcher.view.Animationed;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.RequestCreator;
import logic.exam.DescriptiveQues;
import logic.exam.Exam;
import logic.exam.Question;
import logic.exam.Test;
import logic.net.Client;
import logic.net.ServerConnection;
import logic.user.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Start extends Application {
    private static Stage stage;
    private static BorderPane border;
    public static  Animationed anime;
    @Override
    public void start(Stage stage) throws Exception {
        this.setStage(stage);
        getStage().setTitle("سیستم آزمون یار");
        getStage().setResizable(false);
        getStage().getIcons().add(new Image(getClass()
                .getResource("resource/logo.png").toString()));
        showLoginPage();
        showLoginItems();
        anime = new Animationed(50, border, 0.1);
        anime.generateAnimation();
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
        setBorder(loader.load());
        Scene scene = new Scene(getBorder());
        getStage().setScene(scene);
        getStage().show();
    }

    public static void main(String[] args) {

        //Client client = new Client();
        // RequestCreator.setClient(client);
        // new Thread(client).start();

        new Thread(Client.CLIENT).start();
        launch(args);
    }


    public static Stage getStage() {
        return stage;
    }

    public static BorderPane getBorder() {
        return border;
    }

    public static void setStage(Stage aStage) {
        stage = aStage;
    }

    public static void setBorder(BorderPane aBorder) {
        border = aBorder;
    }

}


