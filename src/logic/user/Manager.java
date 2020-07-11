package logic.user;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Manager extends User implements Serializable {
    public Manager(String firstName, String lastName, String password, String username) {
        super(firstName, lastName, password, username);
    }

    public Manager(String password, String username) {
        super(password, username);
    }

    @Override
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("firstName", this.getFirstName());
        obj.put("lastName", this.getLastName());
        obj.put("username", this.getUsername());
        obj.put("password", this.getPassword());
        obj.put("roll","manager");
        return obj;
    }
}
