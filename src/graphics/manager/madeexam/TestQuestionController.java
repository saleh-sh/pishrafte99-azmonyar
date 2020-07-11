package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import graphics.launcher.Start;
import logic.exam.ExamCreator;
import logic.exam.Test;
import manager.tools.FormattedFiled;

public class TestQuestionController implements Initializable {

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
    @FXML
    private TextField firstOption;
    @FXML
    private TextField secondOption;
    @FXML
    private TextField thirdOption;
    @FXML
    private TextField fourthOption;
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

        List<String> optionList = Arrays.asList(firstOption.getText(), secondOption.getText(), thirdOption.getText(), fourthOption.getText());
        LinkedList<String> options = new LinkedList<>(optionList);
        double point = Double.valueOf(pointField.getText());
        String questionText = questionField.getText();
        Test test;
        if (isTime.isSelected()) {
            int time = Integer.parseInt(minTime.getText());
            test = new Test(options, time, numQue, point, questionText);
            System.out.println(numQue);
        } else {
            test = new Test(point, questionText, options);
        }
        ExamCreator.getExam().addQuestion(test);
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
