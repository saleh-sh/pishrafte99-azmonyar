package graphics.student.exam;

import graphics.launcher.Start;
import graphics.student.MainPageController;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import logic.exam.*;

public class ExamBorderController implements Initializable {

    @FXML
    private Label timeLabel;
    @FXML
    private GridPane gridQuestion;
    @FXML
    private Label timeRemaining;

    @FXML
    private Label examName;
    @FXML
    private Label liveDate;
    private Exam exam;
    @FXML
    private Button finishExam;
    @FXML
    private Button nextQuestionButton;
    private int numQue = 0;

    public void nextQuestionButtonAction() {
        numQue++;
        if (exam.getQuestions().size() - 1 == numQue) {
            nextQuestionButton.setText("اتمام آزمون");
        }

        if (exam.getQuestions().size() == numQue) {
            finishExamAction();
        }
        loadingQuestion();
    }

    public void finishExamAction() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainPageController.class.getResource("TopBorder.fxml"));

        try {
            Start.setBorder(loader.load());

            Scene scene = new Scene(Start.getBorder());
            Start.getStage().setScene(scene);
            Start.getStage().show();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(MainPageController.class.getResource("MainPage.fxml"));
            BorderPane border = loader1.load();
            Start.getBorder().setCenter(border);
            graphics.student.TopBorderController userController = (graphics.student.TopBorderController) loader.getController();
            // userController.getUser(txtEnterUsername.getText());
            graphics.student.MainPageController userController2 = (graphics.student.MainPageController) loader1.getController();
            //just for test we should add it when we get groups chat from database
            userController2.setGroups(new String[]{"گروه اول", "گروه دوم"});
        } catch (IOException ex) {
            System.out.println("expection");

        }
    }

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
            liveDate.setText(LocalDate.now().toString());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

    public void loadingQuestion() {
        FXMLLoader loader1 = new FXMLLoader();
        try {
            if (exam.getQuestions().get(numQue) instanceof DescriptiveQues) {
                loader1.setLocation(getClass().getResource("DesQuestion.fxml"));
                BorderPane border = loader1.load();
                Start.getBorder().setCenter(border);
                DesQuestionController userController2 = (DesQuestionController) loader1.getController();
                userController2.setQuestion((DescriptiveQues) exam.getQuestions().get(numQue));
            } else if (exam.getQuestions().get(numQue) instanceof Test) {
                loader1.setLocation(getClass().getResource("testQuestion.fxml"));
                BorderPane border = loader1.load();
                Start.getBorder().setCenter(border);
                TestQuestionController userController2 = (TestQuestionController) loader1.getController();
                userController2.setQuestion((Test) exam.getQuestions().get(numQue));
            } else {
                loader1.setLocation(getClass().getResource("TFQuestion.fxml"));
                BorderPane border = loader1.load();
                Start.getBorder().setCenter(border);
                TFQuestionController userController2 = (TFQuestionController) loader1.getController();
                userController2.setQuestion((True_False_ques) exam.getQuestions().get(numQue));
            }
        } catch (Exception e) {
            System.out.println("not found");
        }
        if (exam.getQuestions().size() - 1 == numQue) {
            nextQuestionButton.setText("اتمام آزمون");
        }else{
            nextQuestionButton.setText("سوال بعدی");
        }

    }

    public void setExam(Exam exam) {
        this.exam = exam;
        examName.setText(exam.getNameExam());
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            Remainig();
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        setQuestionButtons();
        loadingQuestion();

    }

    public void setQuestionButtons() {
        gridQuestion.setHgap(5);
        gridQuestion.setVgap(5);
        for (int r = 0; r < exam.getQuestions().size(); r++) {
            Button button = new Button(Integer.toString(r + 1));
            button.setFont(Font.font("B Koodak", 12));
            button.setPrefSize(30, 30);
            button.setMinHeight(button.getPrefHeight());
            button.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            button.setAlignment(Pos.CENTER);
            int x = r;
            button.setOnMousePressed((event) -> {
                if (event.getClickCount() == 2) {
                    numQue = x;
                    loadingQuestion();
                }
            });
            gridQuestion.add(button, r % 4, r / 4);
            GridPane.setHalignment(button, HPos.LEFT);
            GridPane.setValignment(button, VPos.CENTER);
        }
    }

    public void Remainig() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(exam.getEndDate().getYear(), exam.getEndDate().getMonthValue(),
                exam.getEndDate().getDayOfMonth(), exam.getEndTime().getHour(), exam.getEndTime()
                .getMinute(), exam.getEndTime().getSecond());
        Calendar calendar = Calendar.getInstance();
        calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(),
                LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond());
        long passed = calendar2.getTimeInMillis() - calendar.getTimeInMillis();
        String diffSeconds = Long.toString(passed / 1000 % 60);
        String diffMinutes = Long.toString(passed / (60 * 1000) % 60);
        String diffHours = Long.toString(passed / (60 * 60 * 1000));
        if (diffSeconds.length() < 2) {
            diffSeconds = "0" + diffSeconds;
        }
        if (diffMinutes.length() < 2) {
            diffMinutes = "0" + diffMinutes;
        }
        if (diffHours.length() < 2) {
            diffHours = "0" + diffHours;
        }

        timeRemaining.setText(diffHours + " : " + diffMinutes + " : " + diffSeconds);
        if (diffHours.matches("00") && diffMinutes.matches("00") && diffSeconds.matches("00")) {
            finishExamAction();
        }
    }
}
