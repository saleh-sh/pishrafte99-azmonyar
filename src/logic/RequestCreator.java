package logic;

import logic.exam.Exam;
import logic.user.Manager;
import logic.user.Student;
import logic.user.User;
import org.json.simple.JSONObject;

public class RequestCreator {

    private static JSONObject request;
    private final int MAN_SIGN_UP = 111;
    private final int USER_SIGN_IN = 112;
    private final int STUDENT_SIGN_UP = 113;
    private final int NEW_EXAM = 114;
    private final int STUDENT_READY_EXAMS = 115;



    public static JSONObject getRequest() {
        return request;
    }

    public static void setRequest(JSONObject request) {
        RequestCreator.request = request;
    }


    public void createManagerSUReq(Manager manager) {
        JSONObject object = manager.toJson();
        object.put("code", new Integer(MAN_SIGN_UP));
        request = object;
        //client.setObject(object);
    }


    public void createUserSIreq(User user) {
        JSONObject object = user.toJson();
        object.put("code", new Integer(USER_SIGN_IN));
        request = object;

    }

    public void createStudentSUreq(Student student) {

        JSONObject object = student.toJson();
        object.put("code", new Integer(STUDENT_SIGN_UP));
        request = object;
    }

    public void createExamReq(Exam exam) {
        JSONObject object = exam.toJson();
        object.put("code", new Integer(NEW_EXAM));
        request = object;
    }

    public void createStudentExamsReq(Student student){

        JSONObject object = student.toJson();
        object.put("code",new Integer(STUDENT_READY_EXAMS));
        request = object;
    }
}
