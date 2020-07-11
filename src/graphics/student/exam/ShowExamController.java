package graphics.student.exam;

import graphics.launcher.Start;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import logic.exam.*;

public class ShowExamController implements Initializable {

    @FXML
    private GridPane examGrid;
    @FXML
    private Button beforeStep;
    public void beforeStepAction(){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Exam exam = new Exam("ریاضیات گسسته", LocalDate.of(2020,7, 11), LocalTime.of(11, 00,00),
                    LocalDate.of(2020,7, 11), LocalTime.of(13, 00,00));
       /* exam.question.add("یبسیب یبسیسشبنم یسکن ش  تیسب یبشس بشسبش  سنکمبش حتسشب تکیسبسمشنب سش");
        exam.question.add("یبیس بسی سبس کلمب تا سیبک سیبستن سیبسی خادون ددا اخدا کمکم کن بسس");
        exam.question.add("خدایا کمک کن از دست این زندگی نکبت بار دیگه خسته شدم");
        exam.question.add("اگه این سوال و تونستی جواب می دی بتونی مینتی وت عاسایا هابسرسر");*/
        setGroups(new Exam[]{exam,
            new Exam("فارسی عمومی", LocalDate.of(2020, 11, 23), LocalTime.of(21, 30,00),
                    LocalDate.of(2020,11, 23), LocalTime.of(23, 30,00)),
            new Exam("ریاضی عمومی 2", LocalDate.of(2020, 11, 23), LocalTime.of(21, 30,00),
                    LocalDate.of(2020,11, 24), LocalTime.of(3, 30,00)),
            new Exam("ریاضی عمومی 2", LocalDate.of(2020, 11, 23), LocalTime.of(21, 30,00),
                    LocalDate.of(2020,11, 24), LocalTime.of(3, 30,00)),
            new Exam("ریاضی عمومی 2", LocalDate.of(2020, 11, 23), LocalTime.of(21, 30,00),
                    LocalDate.of(2020,11, 24), LocalTime.of(3, 30,00)),
            new Exam("ریاضی عمومی 2", LocalDate.of(2020, 11, 23), LocalTime.of(21, 30,00),
                    LocalDate.of(2020,11, 24), LocalTime.of(3, 30,00))
                });
    }

    public void setGroups(Exam[] exams) {
        examGrid.setVgap(10);
        examGrid.setHgap(5);
     
        for (int r = 0; r < exams.length; r++) {
            Button button = new Button("نام آزمون : " + exams[r].getNameExam() + "\nتاریخ  : \t" + exams[r]
                    .getStartDate()
                    + "\nساعت  : \t" + exams[r].getStartTime());
            button.setFont(Font.font("B Koodak", 18));
            button.setPrefSize(300, 100);
            button.setMinHeight(button.getPrefHeight());
            button.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            button.setAlignment(Pos.TOP_LEFT);
            button.setStyle(""
                    + "-fx-background-radius:10;"
                    + "-fx-border-color:white;"
                    + "-fx-border-radius:10;"
                    + "-fx-border-width:1");
            int x =r;
            button.setOnMousePressed((event) -> {
                if (event.getClickCount() == 2) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("startAnswer.fxml"));
                    try {
                        BorderPane border = loader.load();
                        Start.getBorder().setCenter(border);
                        graphics.student.exam.StartAnswerController userController
                                = (graphics.student.exam.StartAnswerController) loader.getController();
                        userController.setExam(exams[x]);
                    } catch (IOException ex) {
                        System.out.println("Border Not Found");
                    }
                }
            });
            examGrid.add(button, r % 2, r / 2);
            GridPane.setHalignment(button, HPos.LEFT);
            GridPane.setValignment(button, VPos.CENTER);
        }
    }

}
