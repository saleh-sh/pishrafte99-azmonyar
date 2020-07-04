package graphics.student;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MainPageController implements Initializable {

    private String[] groupsName = {};
    @FXML
    private GridPane gridGroups;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label timeLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            String min = Integer.toString(currentTime.getMinute());
            String sec = Integer.toString(currentTime.getSecond());
            if (min.length() == 1) {
                min = "0" + min;
            }
            if (sec.length() == 1) {
                sec = "0" + sec;
            }
            timeLabel.setText(currentTime.getHour() + ":" + min + ":" + sec);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

    public void getUser(String user) {
        welcomeLabel.setText("کاربر" + " : " + user);
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
            gridGroups.add(button, 0, r);
            GridPane.setHalignment(button, HPos.CENTER);
            GridPane.setValignment(button, VPos.CENTER);
        }
    }
}
