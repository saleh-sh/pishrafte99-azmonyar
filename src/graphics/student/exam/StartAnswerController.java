package graphics.student.exam;

import graphics.launcher.Start;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.LocalDateTimeStringConverter;
import logic.exam.*;


public class StartAnswerController implements Initializable {

    private Exam exam;
    @FXML
    private Label examName;
    @FXML
    private Button beforeStep;
    @FXML
    private Button enterExam;
    @FXML
    private Button refresh;
    @FXML
    private Label examStartDate;
    @FXML
    private Label examStartTime;
    @FXML
    private Label examDuration;

    public void beforeStepAction() {

    }

    public void enterExamAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("examBorder.fxml"));

        Start.setBorder(loader.load());
        Scene scene = new Scene(Start.getBorder());
        Start.getStage().setScene(scene);
        Start.getStage().show();

        
        ExamBorderController userController = (ExamBorderController) loader.getController();
       
        LinkedList<String> link = new LinkedList<>();
        link.add("در مشامم میفرسد هر لحظه بوی کربلا");
        link.add("سلام من به تو یار قدیمی");
        link.add("در سمت توام دلم باران دهانم باران چشمم باران");
        link.add("روزم زا با بندگی تو آغاز میکنم");
        
        exam.getQuestions().add(new True_False_ques(10, 1, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new Test(link,10, 2, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new True_False_ques(10, 3, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new True_False_ques(10, 4, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 5, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 6, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new True_False_ques(10, 7, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 8, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 9, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 10, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 11, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 12, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 13, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 14, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 15, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 16, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 17, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 18, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 19, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 20, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 21, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        exam.getQuestions().add(new DescriptiveQues(10, 22, 2.5,"در مشامم میفرسد هر لحظه بوی کربلا"));
        
        
        
        userController.setExam(this.exam);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setExam(Exam exam) {
        this.exam = exam;
        examName.setText(exam.getNameExam());
        examStartDate.setText(exam.getStartDate().toString());
        examStartTime.setText(exam.getStartTime().toString());
        examDuration.setText(Integer.toString(getDuration(exam.getStartTime(), exam.getEndTime(), exam.getStartDate(),
                exam.getEndDate())));
        refreshAction();

    }

    public void refreshAction() {
        if (onDuration()) {
            enterExam.setDisable(false);
        } else {
            enterExam.setDisable(true);
        }
    }

    public boolean onDuration() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(exam.getStartDate().getYear(), exam.getStartDate().getMonthValue(),
                exam.getStartDate().getDayOfMonth(), exam.getStartTime().getHour(), exam.getStartTime()
                .getMinute(), exam.getStartTime().getSecond());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(exam.getEndDate().getYear(), exam.getEndDate().getMonthValue(),
                exam.getEndDate().getDayOfMonth(), exam.getEndTime().getHour(), exam.getEndTime()
                .getMinute(), exam.getEndTime().getSecond());

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(), LocalTime.now()
                .getMinute(), LocalTime.now().getSecond());

        if (calendar3.after(calendar1) && calendar3.before(calendar2)) {
            return true;
        } else {
            return false;
        }
    }

    public int getDuration(LocalTime t1, LocalTime t2, LocalDate d1, LocalDate d2) {
        int length = 0;
        int start = 0;
        start += t1.getHour() * 60 + t1.getMinute();
        length += (d2.getDayOfYear() - d1.getDayOfYear()) * 24 * 60 + t2.getHour() * 60 + t2.getMinute();
        length -= start;
        return length;
    }
}
