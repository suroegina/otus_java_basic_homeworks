package otus.java.basic.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }

        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        System.out.println("К чату подключился: " + clientHandler.getUserName());
        brosdcastMessage("К чату подключился: " + clientHandler.getUserName());
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Из чата вышел: " + clientHandler.getUserName());
        brosdcastMessage("Из чата вышел: " + clientHandler.getUserName());
    }

    public void brosdcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void privateMessage(ClientHandler userFrom, String userTo, String message) {
        for (ClientHandler c : clients) {
            if (userTo.equalsIgnoreCase(c.getUserName())) {
                c.sendMsg(message);
                return;
            }
        }
        userFrom.sendMsg("Такого клиента нет! Введите корректное имя клиента.");
    }
}

