package logic.exam;

import java.util.ArrayList;

public class Test extends Question{

    private ArrayList<String> options;

    public Test(int score, String questionText, ArrayList<String> options) {
        super(score, questionText);
        this.options = options;
    }

    public Test(int time, int score, String questionText, ArrayList<String> options) {
        super(time, score, questionText);
        this.options = options;
    }
}
