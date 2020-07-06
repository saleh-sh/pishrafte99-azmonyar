package logic.exam;

import java.util.ArrayList;

public class Exam {

    private boolean shuffle;
    private boolean review;
    private ExamModel model;
    private ArrayList<Question> questions;
}

enum ExamModel {
    TOGETHER, ONE_BY_ONE;
}
