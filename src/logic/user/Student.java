package logic.user;

public class Student extends User {

    private String studentId;

    public Student(String firstName, String lastName, String password, String username) {
        super(firstName, lastName, password, username);
    }

    public Student(String firstName, String lastName, String password, String username,String studentId){
        this(firstName,lastName,password,username);
        this.studentId = studentId;
    }

    public Student(String password, String username) {
        super(password, username);
    }

    public String getStudentId() {
        return studentId;
    }
}
