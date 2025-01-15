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
    private boolean auth = false;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());


        new Thread(()->{
            try {
                System.out.println("Клиент подключился на порту: " + socket.getPort());
                // цикл аутентификации
                while (true) {
                    sendMsg("Для начала работы нужно пройти аутентификацию. Формат команды: /auth login password \n" +
                            "или регистрацию. Формат команды /reg username password email");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        // /auth login password
                        if (message.startsWith("/auth ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 3) {
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .authenticate(this, elements[1], elements[2])){
                                auth = true;
                                break;
                            }
                        }
                        // /reg username password email
                        if (message.startsWith("/reg ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 4) {
                                sendMsg("Неверный формат команды /reg");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .registration(this, elements[1], elements[2], elements[3])){
                                auth = true;
                                break;
                            }
                        }
                    }
                }
                // цикл работы
                while (auth) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {

                        if (message.startsWith("/w")){
                            String[] substr = message.split(" ", 3);
                            try {
                                server.privateMessage(this, substr[1], userName + " (лично вам): " + substr[2]);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                server.privateMessage(this, userName, "Некорректная команда. Пример: /w username message_to_user");
                            }
                        } else if (message.startsWith("/exit")) {
                            sendMsg("/exitok");
                            break;
                        } else if (message.startsWith("/kick")) {
                            // /kick username
                            String[] elements = message.split(" ");

                            if (elements.length != 2) {
                                sendMsg("Неверный формат команды /kick");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .kick(this, elements[1])){
                                server.brosdcastMessage(userName + " удалил из чата " + elements[1]);
                            }
                        } else {
                            server.privateMessage(this, userName, "Такой команды нет.");
                        }
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

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
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
