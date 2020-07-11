package logic.net;

import logic.exam.Exam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServerResponseHandler {


    public Exam[] getStudentReadyExams() {

        JSONArray examArray = (JSONArray) ServerConnection.SERVER_CONNECTION.getFeedback();
        Exam[] exams = new Exam[examArray.size()];

        for (int i = 0; i < examArray.size(); i++) {
            JSONObject examJSON = (JSONObject) examArray.get(i);

            LocalTime start = (LocalTime) examJSON.get("startTime");
            LocalTime end = (LocalTime) examJSON.get("endTime");
            LocalDate startDate = (LocalDate) examJSON.get("startDate");
            LocalDate endDate = (LocalDate) examJSON.get("endDate");
            String examName = (String) examJSON.get("name");
            exams[i] = new Exam(examName,startDate,start,endDate,end);

        }
        return exams;
    }
}
