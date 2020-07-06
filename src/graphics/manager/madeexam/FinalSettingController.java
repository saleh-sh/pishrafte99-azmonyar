package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.DateTimeStringConverter;
import graphics.launcher.Start;

public class FinalSettingController implements Initializable {

    @FXML
    private Button nextStep;
    @FXML
    private TextField startTimeExamField;
    @FXML
    private TextField endTimeExamField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            startTimeExamField.setTextFormatter(new TextFormatter<>
                (new DateTimeStringConverter(format), format.parse("00:00:00")));
            endTimeExamField.setTextFormatter(new TextFormatter<>
                (new DateTimeStringConverter(format), format.parse("00:00:00")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void nextStepAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SaveExam.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
    }

}
