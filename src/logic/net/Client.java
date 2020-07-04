package logic.net;

import logic.RequestCreator;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 9090;
    private JSONObject object = null;

    public void setObject(JSONObject object) {
        this.object = object;
    }


    @Override
    public void run() {
        Socket socket = null;
        ServerConnection serverConn = null;
        ObjectOutputStream outputStream = null;

        try {
            socket = new Socket(IP, PORT);
            serverConn = new ServerConnection(socket);
            outputStream = new ObjectOutputStream(socket.getOutputStream());


        } catch (IOException ex) {
            ex.printStackTrace();
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


