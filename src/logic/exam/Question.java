package logic.exam;

import org.json.simple.JSONObject;

public abstract class Question {

    protected int time;
    protected double point;
    protected String questionText;

    public Question(double point, String questionText) {
        this.point = point;
        this.questionText = questionText;
    }

    public Question(int time, double point, String questionText) {
        this(point,questionText);
        this.time = time;

    }

    public  JSONObject toJson(){
        JSONObject object = new JSONObject();
        object.put("QText",questionText);
        object.put("point",new Double(point));
        object.put("time",new Integer(time));
        return object;
    }
}
