package otus.java.basic.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        authenticatedProvider = new InMemoryAuthenticatedProvider(this);
    }

    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        brosdcastMessage("К чату подключился: " + clientHandler.getUserName());
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        brosdcastMessage("Из чата вышел: " + clientHandler.getUserName());
    }

    public void brosdcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public ClientHandler findClientByUsername(String username) {
        for (ClientHandler c : clients) {
            if (c.getUserName().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
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

    public boolean isUsernameBusy(String username) {
        for (ClientHandler c : clients) {
            if (c.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }



}

