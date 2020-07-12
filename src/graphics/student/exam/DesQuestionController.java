
package graphics.student.exam;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import logic.exam.DescriptiveQues;

public class DesQuestionController implements Initializable {

    @FXML
    private TextArea questionArea;
    @FXML
    private TextArea answerArea;
    @FXML
    private Label PointAns;
    @FXML
    private Label NumQue;
    @FXML
    private Button nextQuestionButton;
    @FXML
    private Button browseButton;
    @FXML
    private Label pathFileLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void nextQuestionButtonAction() {

    }

    public void browseButtonAction() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            pathFileLabel.setText("Selected File:" + file.getAbsolutePath());
        }
    }
    public void setQuestion(DescriptiveQues question) {
        questionArea.setText(question.questionText);
        NumQue.setText(Integer.toString(question.numQue));
        PointAns.setText("" + question.point);
    }

}
