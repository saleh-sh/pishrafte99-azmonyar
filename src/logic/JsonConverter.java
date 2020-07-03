package logic;

import logic.user.Manager;
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
}
