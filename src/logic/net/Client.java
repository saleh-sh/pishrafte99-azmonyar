package logic.net;

import logic.RequestCreator;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    public static final String IP = "127.0.0.1";
    public static final int PORT = 9090;
    public static final Client CLIENT = new Client();
    private Client(){

    }
   // private JSONObject object = null;
/*
    public void setObject(JSONObject object) {
        this.object = object;
    }
*/

    @Override
    public void run() {
        Socket socket = null;
        ServerConnection serverConn = null;
        ObjectOutputStream outputStream = null;

        try {
            socket = new Socket(IP, PORT);
            serverConn = ServerConnection.SERVER_CONNECTION;//new ServerConnection(socket);
            outputStream = new ObjectOutputStream(socket.getOutputStream());


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        serverConn.setServer(socket);
        try {
            serverConn.setIn(new ObjectInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(serverConn).start();

        while (true) {

            try {
                if (RequestCreator.getRequest() != null) {
                    outputStream.writeObject(RequestCreator.getRequest());
                    RequestCreator.setRequest(null);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
       /* try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

/*
    public static void main(String[] args) {
        Client client = new Client();
        new Thread(client).start();
    }*/
}


