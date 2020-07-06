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
import javafx.util.StringConverter;
import graphics.launcher.Start;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        minTime.setTextFormatter (new FormattedFiled().getDoubleFormatter());
        pointField.setTextFormatter (new FormattedFiled().getDoubleFormatter());
    }
    
    
    public void madeQuestion() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddQuestion.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
        AddQuestionController userController = (AddQuestionController) loader.getController();
        userController.addQuestion(questionField.getText());
    }

    public void isTimeAction() {
        if (isTime.isSelected()) {
            minTime.setDisable(false);
        } else {
            minTime.setDisable(true);
        }
    }

}
