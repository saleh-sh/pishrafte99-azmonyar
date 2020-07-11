package graphics.student;

import graphics.launcher.Start;
import graphics.launcher.view.Animationed;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import logic.RequestCreator;
import logic.user.Student;
import logic.user.UserHandler;


public class MainPageController implements Initializable {

    private String[] groupsName = {""};
    @FXML
    private GridPane gridGroups;

    @FXML
    private Button reviewExamsButton;
    @FXML
    private Button studentExamButton;
    @FXML
    private Button scoreExamButtonAction;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Start.anime = new Animationed(50, Start.getBorder(), 0.1);
        Start.anime.generateAnimation();
    }


    @FXML
    public void reviewExamsButtonAction() {

    }

    @FXML
    public void studentExamButtonAction() throws IOException {

        RequestCreator requestCreator = new RequestCreator();
        requestCreator.createStudentExamsReq((Student) UserHandler.getOnlineUser());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("exam/ShowExam.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
    }

    @FXML
    public void scoreExamButtonAction() {

    }


    public void setGroups(String[] groupArray) {
        this.groupsName = groupArray;
        gridGroups.setVgap(15);
        gridGroups.setPadding(new Insets(10));
        for (int r = 0; r < groupsName.length; r++) {
            Button button = new Button(groupsName[r]);
            button.setFont(Font.font("B Koodak", 20));
            button.setPrefSize(170, 50);
            button.setMinHeight(button.getPrefHeight());
            button.setStyle(""
                    + "-fx-background-radius:10;"
                    + "-fx-border-color:white;"
                    + "-fx-border-radius:10;"
                    + "-fx-border-width:1");
            button.setOnMousePressed((event) -> {
                if (event.getClickCount() == 2) {
                    System.out.println("two ");
                }
            });
            gridGroups.add(button, 0, r);
            GridPane.setHalignment(button, HPos.CENTER);
            GridPane.setValignment(button, VPos.CENTER);
        }
    }
}
