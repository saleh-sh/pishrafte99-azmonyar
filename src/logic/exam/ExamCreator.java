package logic.exam;


public class ExamCreator {


    private static Exam exam = new Exam();

    public static Exam getExam() {
        return exam;
    }

    public static void reStart() {
        exam = new Exam();
    }

}
