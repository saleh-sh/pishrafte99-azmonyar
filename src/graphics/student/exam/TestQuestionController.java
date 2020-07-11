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
import logic.exam.*;
public class TestQuestionController implements Initializable {

    @FXML
    ToggleGroup answerGroup;
    @FXML
    private TextArea questionArea;
    @FXML
    private Label FirstQue;
    @FXML
    private Label SecondQue;
    @FXML
    private Label ThirdQue;
    @FXML
    private Label FourthQue;
    @FXML
    private Label PointAns;
    @FXML
    private Label NumQue;
    @FXML
    private RadioButton FirstAns;
    @FXML
    private RadioButton SecondAns;
    @FXML
    private RadioButton ThirdAns;
    @FXML
    private RadioButton FourthAns;
    @FXML
    private Button nextQuestionButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // T
    }

    public void nextQuestionButtonAction() {

    }

    public void setQuestion(Test question) {
        questionArea.setText(question.questionText);
        NumQue.setText(Integer.toString(question.numQue));
        PointAns.setText("" + question.point);
        FirstQue.setText(question.getOptions().get(0));
        SecondQue.setText(question.getOptions().get(1));
        ThirdQue.setText(question.getOptions().get(2));
        FourthQue.setText(question.getOptions().get(3));
    }

}
