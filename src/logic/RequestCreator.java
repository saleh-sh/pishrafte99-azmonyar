package logic;

import logic.net.Client;
import logic.user.Manager;
import org.json.simple.JSONObject;

public class RequestCreator {

    private static Client client;

    public static void setClient(Client client) {
        RequestCreator.client = client;
    }

    public void createManagerSUReq(Manager manager) {
        JSONObject object = JsonConverter.convertManager(manager);
        object.put("code", new Integer(111));

      //  System.out.println("Json" + object);
        System.out.println("client: " + client);

        client.setObject(object);
    }

}
