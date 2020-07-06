
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        minTime.setTextFormatter (new FormattedFiled().getDoubleFormatter());
        pointField.setTextFormatter (new FormattedFiled().getDoubleFormatter());
    }    
    public void madeQuestion() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddQuestion.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
        AddQuestionController userController = (AddQuestionController) loader.getController();
        userController.addQuestion(questionField.getText());
    }
    public void isTimeAction(){
        if (isTime.isSelected()) {
            minTime.setDisable(false);
        }else{
            minTime.setDisable(true);
        }
    }
}
