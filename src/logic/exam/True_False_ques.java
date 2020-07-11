package logic.exam;


import java.io.Serializable;

public class True_False_ques extends Question implements Serializable {

    public True_False_ques( int numQue, double point, String questionText) {
        super( numQue, point, questionText);
    }

    public True_False_ques(double time, int numQue, double point, String questionText) {
        super(time, numQue, point, questionText);
    }


}

