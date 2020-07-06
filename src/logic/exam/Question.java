package logic.exam;

public abstract class Question {

    protected int time;
    protected int score;
    protected String questionText;

    public Question(int score, String questionText) {
        this.score = score;
        this.questionText = questionText;
    }

    public Question(int time, int score, String questionText) {
        this(score,questionText);
        this.time = time;

    }
}
