/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.student.exam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import logic.exam.True_False_ques;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class TFQuestionController implements Initializable {

    @FXML
    ToggleGroup answerGroup;
    @FXML
    private TextArea questionArea;
    @FXML
    private Label PointAns;
    @FXML
    private Label NumQue;
    @FXML
    private RadioButton wrongAns;
    @FXML
    private RadioButton correctAns;
    @FXML
    private Button nextQuestionButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // T
    }

    public void nextQuestionButtonAction() {

    }

    public void setQuestion(True_False_ques question) {
        questionArea.setText(question.questionText);
        NumQue.setText(Integer.toString(question.numQue));
        PointAns.setText("" + question.point);
    }
    
}
