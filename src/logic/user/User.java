package logic.user;

import org.json.simple.JSONObject;

import java.io.Serializable;

public abstract class User implements Serializable {

    protected String firstName;
    protected String lastName;
    protected String password;
    protected String username;

    public User(String firstName, String lastName, String password, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("username", this.getUsername());
        obj.put("password", this.getPassword());

        return obj;
    }
}




