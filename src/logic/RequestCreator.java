package logic;

import logic.net.Client;
import logic.user.Manager;
import org.json.simple.JSONObject;

public class RequestCreator {

    private static Client client;
    private static JSONObject request;

    public static void setClient(Client client) {
        RequestCreator.client = client;
    }

    public void createManagerSUReq(Manager manager) {
        JSONObject object = JsonConverter.convertManager(manager);
        object.put("code", new Integer(111));
request = object;
        //client.setObject(object);
    }

    public static JSONObject getRequest() {
        return request;
    }

    public static void setRequest(JSONObject request) {
        RequestCreator.request = request;
    }
}
