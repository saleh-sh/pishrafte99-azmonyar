package logic.exam;

import org.json.simple.JSONObject;

public abstract class Question {

    protected int time;
    public int numQue;
    public double point;
    public String questionText;

    public Question(int time, int numQue, double point, String questionText) {
        this.time = time;
        this.numQue = numQue;
        this.point = point;
        this.questionText = questionText;
    }
    
    
    public Question(double point, String questionText) {
        this.point = point;
        this.questionText = questionText;
    }


    public  JSONObject toJson(){
        JSONObject object = new JSONObject();
        object.put("QText",questionText);
        object.put("point",new Double(point));
        object.put("time",new Integer(time));
        return object;
    }
}
