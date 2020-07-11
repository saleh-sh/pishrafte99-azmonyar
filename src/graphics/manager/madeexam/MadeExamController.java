
package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import graphics.launcher.Start;
import logic.exam.ExamCreator;

public class MadeExamController implements Initializable {

    @FXML
    private Button makeExamButton;

    @FXML
    private TextField examName;

    public void makeExamButtonAction() throws IOException {

        String name = examName.getText();
        ExamCreator.getExam().setNameExam(name);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddQuestion.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Start.anime.setColorAnimation(Color.LIGHTCYAN,0.25);
    }

}
