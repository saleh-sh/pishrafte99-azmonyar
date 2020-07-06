package logic.exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Exam {

    private boolean shuffle;
    private boolean review;
    private ExamModel model;
    private ArrayList<Question> questions;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalDate endTime;
}

enum ExamModel {
    TOGETHER, ONE_BY_ONE;
}
