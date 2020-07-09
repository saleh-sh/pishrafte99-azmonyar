package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.DateTimeStringConverter;
import graphics.launcher.Start;
import logic.exam.ExamCreator;

public class FinalSettingController implements Initializable {

    @FXML
    private Button nextStep;
    @FXML
    private TextField startTimeExamField;
    @FXML
    private TextField endTimeExamField;
    @FXML
    private CheckBox shuffleCheckBox;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private CheckBox examModel;
    @FXML
    private CheckBox reviewCheckBox;

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


    //این متد شی امتحان را ساخته و برای ارسال به سرور قرار می دهد
    public void nextStepAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SaveExam.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
        LocalTime startTime = LocalTime.parse(startTimeExamField.getText());
        LocalTime endTime = LocalTime.parse(endTimeExamField.getText());
        ExamCreator.getExam().setEndTime(endTime);
        ExamCreator.getExam().setStartTime(startTime);
        ExamCreator.getExam().setEndDate(endDate.getValue());
        ExamCreator.getExam().setStartDate(startDate.getValue());

        ExamCreator.getExam().setShuffle(false);
        ExamCreator.getExam().setReview(false);
        if (examModel.isSelected()) {
            ExamCreator.getExam().setModel("ONEBYONE");
        } else {
            ExamCreator.getExam().setModel("TOGETHER");
        }
        if (shuffleCheckBox.isSelected()) {
            ExamCreator.getExam().setShuffle(true);
        }
        if (reviewCheckBox.isSelected()) {
            ExamCreator.getExam().setReview(true);
        }

    }

}
