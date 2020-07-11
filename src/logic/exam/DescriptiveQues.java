package logic.exam;

import java.io.Serializable;

public class DescriptiveQues extends Question implements Serializable {


     public DescriptiveQues( int numQue, double point, String questionText) {
        super(numQue, point, questionText);
    }
    public DescriptiveQues(double time, int numQue, double point, String questionText) {
        super(time, numQue, point, questionText);
    }
    
}