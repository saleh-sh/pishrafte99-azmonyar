package logic;

import logic.net.Client;
import logic.user.Manager;
import logic.user.Student;
import logic.user.User;
import org.json.simple.JSONObject;

public class RequestCreator {

    // private static Client client;
    private static JSONObject request;
    private final int MAN_SIGN_UP = 111;
    private final int USER_SIGN_IN = 112;
    private final int STUDENT_SIGN_UP = 113;

/*
    public static void setClient(Client client) {
        RequestCreator.client = client;
    }
*/


    public static JSONObject getRequest() {
        return request;
    }

    public static void setRequest(JSONObject request) {
        RequestCreator.request = request;
    }

    public void createManagerSUReq(Manager manager) {
        JSONObject object = JsonConverter.convertManager(manager);
        object.put("code", new Integer(MAN_SIGN_UP));
        request = object;
        //client.setObject(object);
    }

    public void createUserSIreq(User user) {
        JSONObject object = JsonConverter.convertUser(user);
        object.put("code", new Integer(USER_SIGN_IN));
        request = object;

    }

    public void createStudentSUreq(Student student) {
        JSONObject object = JsonConverter.convertStudent(student);
        object.put("code", new Integer(STUDENT_SIGN_UP));
        request = object;
    }
}
