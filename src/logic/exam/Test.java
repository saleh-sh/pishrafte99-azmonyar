package logic.exam;

import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.LinkedList;

public class Test extends Question implements Serializable {

    private LinkedList<String> options;
    public Test(LinkedList<String> options, int numQue, double point, String questionText) {
        super( numQue, point, questionText);
        this.options = options;
    }
    public Test(LinkedList<String> options, double time, int numQue, double point, String questionText) {
        super(time, numQue, point, questionText);
        this.options = options;
    }

    public LinkedList<String> getOptions() {
        return options;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("QText", questionText);
        object.put("point", new Double(point));
        object.put("options", options);
        object.put("time", time);
        return object;
    }
}
