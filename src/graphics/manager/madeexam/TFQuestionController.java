/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import graphics.launcher.Start;
import logic.exam.ExamCreator;
import logic.exam.Test;
import logic.exam.True_False_ques;
import manager.tools.FormattedFiled;

public class TFQuestionController implements Initializable {

    @FXML
    private Button madeQuestion;
    @FXML
    private CheckBox isTime;
    @FXML
    private TextField minTime;
    @FXML
    private TextArea questionField;
    @FXML
    private TextField pointField;
    private int numQue = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        minTime.setTextFormatter(new FormattedFiled().getDoubleFormatter());
        pointField.setTextFormatter(new FormattedFiled().getDoubleFormatter());
    }

    public void madeQuestion() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddQuestion.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
        AddQuestionController userController = (AddQuestionController) loader.getController();
        userController.addQuestion(questionField.getText());

        String questionText = questionField.getText();
        double point = Double.valueOf(pointField.getText());
        True_False_ques trueFalseQues;
        if (isTime.isSelected()) {
            double time = Double.parseDouble(minTime.getText());
            trueFalseQues = new True_False_ques(time, numQue, point, questionText);
    } else {
            trueFalseQues = new True_False_ques(numQue,point, questionText);
        }
        ExamCreator.getExam().addQuestion(trueFalseQues);
        System.out.println(trueFalseQues.toJson());
    }
    
    public void isTimeAction() {
        if (isTime.isSelected()) {
            minTime.setDisable(false);
        } else {
            minTime.setDisable(true);
        }
    }

    public void setNumQue(int numQue) {
        this.numQue = numQue;
    }

}
