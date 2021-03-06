package logic.net;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket server;
    //private BufferedReader in;
    private ObjectInputStream in;
    //به وسیله این کد ها ارتباط بین سرور و کلاینت برقرا میشود
    private final int MAN_SIGN_UP = 111;
    private final int USER_SIGN_IN = 112;
    private final int STUDENT_READY_EXAMS = 115;
    public static final ServerConnection SERVER_CONNECTION = new ServerConnection();
    //private JSONObject feedback;
    //فقط ورود مدیز و دانشجو
    private Object feedback;

    /*public ServerConnection(Socket s) throws IOException {
        this.server = s;
        //in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        in = new ObjectInputStream(server.getInputStream());
    }*/


    private ServerConnection() {
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public void setServer(Socket server) {
        this.server = server;
    }

    public Object getFeedback() {
        return feedback;
    }

    @Override
    public void run() {

        try {
            while (true) {
                //String serverResponse = in.readLine();
                //if (serverResponse == null) {
                //break;
                //}
                //System.out.println("Server says: " + serverResponse);

                feedback = in.readObject();
                System.out.println("feedback in server connection"+feedback);

                /*
                JSONObject serverResponse = (JSONObject) in.readObject();

                if ((int) serverResponse.get("code") == MAN_SIGN_UP) {
                    System.out.println(serverResponse);
                }
                if ((int) serverResponse.get("code") == USER_SIGN_IN) {
                    feedback = serverResponse;
                }
                if ((int)serverResponse.get("code") == STUDENT_READY_EXAMS){
                    feedback = serverResponse;
                }*/
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}

