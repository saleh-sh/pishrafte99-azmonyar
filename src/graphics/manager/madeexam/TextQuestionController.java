package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import graphics.launcher.Start;
import logic.exam.DescriptiveQues;
import logic.exam.ExamCreator;
import manager.tools.FormattedFiled;

public class TextQuestionController implements Initializable {

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
        DescriptiveQues descriptiveQues;
        if (isTime.isSelected()) {
            int time = Integer.parseInt(minTime.getText());
            descriptiveQues = new DescriptiveQues(time, numQue, point, questionText);
            System.out.println(numQue);
        } else {
            descriptiveQues = new DescriptiveQues(point, questionText);
        }
        ExamCreator.getExam().addQuestion(descriptiveQues);
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
