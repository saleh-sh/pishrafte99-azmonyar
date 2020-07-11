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
import logic.net.ServerResponseHandler;

public class ShowExamController implements Initializable {

    @FXML
    private GridPane examGrid;
    @FXML
    private Button beforeStep;
    public void beforeStepAction(){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServerResponseHandler responseHandler = new ServerResponseHandler();
        Exam[] exams = responseHandler.getStudentReadyExams();
        setGroups(exams);
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
                        System.err.println("Border Not Found");
                    }
                }
            });
            examGrid.add(button, r % 2, r / 2);
            GridPane.setHalignment(button, HPos.LEFT);
            GridPane.setValignment(button, VPos.CENTER);
        }
    }

}
