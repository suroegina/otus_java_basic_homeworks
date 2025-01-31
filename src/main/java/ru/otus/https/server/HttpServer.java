package ru.otus.https.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        int counter = 0;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                counter++;
                try (Socket socket = serverSocket.accept()) {
                    int number = counter;
                        try {
                            System.out.println("Подключился новый клиент #" + number);
                            byte[] buffer = new byte[8192];
                            int n = socket.getInputStream().read(buffer);
                            HttpRequest request = new HttpRequest(new String(buffer, 0, n));
                            request.info(true);
                            dispatcher.execute(request, socket.getOutputStream());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
