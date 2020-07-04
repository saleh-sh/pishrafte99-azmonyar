package logic;

import logic.user.Manager;
import logic.user.Student;
import logic.user.User;
import org.json.simple.JSONObject;

public class JsonConverter {

    public static JSONObject convertManager(Manager manager) {

        JSONObject obj = new JSONObject();
        obj.put("firstName", manager.getFirstName());
        obj.put("lastName", manager.getLastName());
        obj.put("username", manager.getUsername());
        obj.put("password", manager.getPassword());

        return obj;
    }

    public static JSONObject convertUser(User user) {
        JSONObject obj = new JSONObject();
        obj.put("username", user.getUsername());
        obj.put("password", user.getPassword());

        return obj;
    }

    public static JSONObject convertStudent(Student student) {
        JSONObject obj = new JSONObject();
        obj.put("firstName", student.getFirstName());
        obj.put("lastName", student.getLastName());
        obj.put("username", student.getUsername());
        obj.put("password", student.getPassword());
        obj.put("studentId", student.getStudentId());

        return obj;
    }
}
