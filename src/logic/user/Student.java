package logic.user;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Student extends User implements Serializable {

    private String studentId;

    public Student(String firstName, String lastName, String password, String username) {
        super(firstName, lastName, password, username);
    }

    public Student(String firstName, String lastName, String password, String username, String studentId) {
        this(firstName, lastName, password, username);
        this.studentId = studentId;
    }

    public Student(String firstName ,String lastName ,String studentId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.username = studentId;
        this.password = studentId;
    }


    @Override
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("firstName", this.getFirstName());
        obj.put("lastName", this.getLastName());
        obj.put("username", this.getUsername());
        obj.put("password", this.getPassword());
        obj.put("studentId", this.getStudentId());
        obj.put("roll","student");

        return obj;
    }

    public Student(String password, String username) {
        super(password, username);
    }

    public String getStudentId() {
        return studentId;
    }
}
