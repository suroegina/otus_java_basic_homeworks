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
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            ExecutorService service = Executors.newFixedThreadPool(3);
            while (true) {
                Socket socket = serverSocket.accept();
                service.execute(() -> {
                    try {
                        System.out.println("Подключился новый клиент");
                        byte[] buffer = new byte[8192];
                        int n = socket.getInputStream().read(buffer);
                        HttpRequest request = new HttpRequest(new String(buffer, 0, n));
                        request.info(true);
                        dispatcher.execute(request, socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
