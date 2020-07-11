package logic.exam;

import logic.user.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Exam implements Serializable {

    private boolean shuffle;
    private boolean review;
    private ArrayList<Question> questions;
    private ArrayList<Student> participants;
    private ExamModel model;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private String nameExam;

    public Exam() {
        participants = new ArrayList<>();
        questions = new ArrayList<>();
    }

    public Exam(String name, LocalDate startDate, LocalTime startTime, LocalDate finishDate, LocalTime finishTime) {
        //participants = new ArrayList<>();
        //questions = new ArrayList<>();
        this.nameExam = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = finishDate;
        this.endTime = finishTime;
    }


    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("shuffle", shuffle);
        object.put("review", review);
        JSONArray question_array = new JSONArray();
        JSONArray participant_array = new JSONArray();
        for (Question q : getQuestions()) {
            question_array.add(q.toJson());
        }
        for (Student s : participants) {
            participant_array.add(s.toJson());
            System.out.println(s);
        }
        object.put("questions", question_array);
        object.put("participants", participant_array);
        /////////باید توجه کرد که toString برای JSON فراخوانی شده
        object.put("model", model.toString());
        object.put("startDate", getStartDate());
        object.put("endDate", getEndDate());
        object.put("startTime", getStartTime());
        object.put("endTime", getEndTime());
        object.put("name",nameExam);
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
        this.getQuestions().add(question);
    }

    public void addParticipant(Student student) {
        this.participants.add(student);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getNameExam() {
        return nameExam;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }
}

enum ExamModel {
    TOGETHER, ONEBYONE;
}
