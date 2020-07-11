package logic.exam;

import org.json.simple.JSONObject;

import java.io.Serializable;

public abstract class Question implements Serializable {

    protected double time;
    public int numQue;
    public double point;
    public String questionText;

    public Question(double time, int numQue, double point, String questionText) {
        this.time = time;
        this.numQue = numQue;
        this.point = point;
        this.questionText = questionText;
    }
    public Question( int numQue, double point, String questionText) {
        this.time = time;
        this.numQue = numQue;
        this.point = point;
        this.questionText = questionText;
    }
    
   

    public  JSONObject toJson(){
        JSONObject object = new JSONObject();
        object.put("QText",questionText);
        object.put("point",new Double(point));
        object.put("time",new Double(time));
        return object;
    }
}
