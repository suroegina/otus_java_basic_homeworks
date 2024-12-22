package otus.java.basic.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String userName;
    private static int userCount = 0;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        userName = "User_" + userCount;

        new Thread(()->{
            try {
                System.out.println("Клиент подключился " + socket.getPort());
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        String[] substr = message.split(" ", 3);
                        if (substr[0].equalsIgnoreCase("/w")){
                            server.privateMessage(this, substr[1],substr[2]);
                            continue;
                        }
                        sendMsg("/exitok");
                        break;
                    } else {
                        server.brosdcastMessage(userName + " : " + message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }
        ).start();
    }

    public String getUserName() {
        return userName;
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
