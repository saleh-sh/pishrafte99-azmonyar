package logic.exam;

import logic.user.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Exam {

    private boolean shuffle;
    private boolean review;
    private ArrayList<Question> questions;
    private ArrayList<Student> participants;
    private ExamModel model;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;


    public Exam() {
        participants = new ArrayList<>();
        questions = new ArrayList<>();
    }

      /*  public Exam(boolean shuffle, boolean review, String model, ArrayList<Student> participants, ArrayList<Question> questions, LocalDate startDate
                , LocalDate endDate, LocalTime startTime, LocalTime endTime) {
            this.shuffle = shuffle;
            this.review = review;
            this.model = ExamModel.valueOf(model);
            this.questions = questions;
            this.startDate = startDate;
            this.endDate = endDate;
            this.startTime = startTime;
            this.endTime = endTime;
            this.participants = participants;
        }
*/
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("shuffle", shuffle);
        object.put("review", review);
        //////////
        JSONArray question_array = new JSONArray();
        JSONArray participant_array = new JSONArray();
        for (Question q : questions){
            question_array.add(q.toJson());
        }
        for(Student s : participants){
            participant_array.add(s.toJson());
            System.out.println(s);
        }
        object.put("questions", question_array);
        object.put("participants", participant_array);
        /////////باید توجه کرد که toString برای JSON فراخوانی شده
        object.put("model", model.toString());
        object.put("startDate", startDate);
        object.put("endDate", endDate);
        object.put("startTime", startTime);
        object.put("endTime", endTime);
        return object;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

   public void setModel(String model) {
        this.model = ExamModel.valueOf(model);
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void addParticipant(Student student) {
        this.participants.add(student);
    }
}


enum ExamModel {
    TOGETHER, ONEBYONE;
}
