package logic.user;

public class Student extends User {
    public Student(String firstName, String lastName, String password, String username) {
        super(firstName, lastName, password, username);
    }

    public Student(String password, String username) {
        super(password, username);
    }

}
