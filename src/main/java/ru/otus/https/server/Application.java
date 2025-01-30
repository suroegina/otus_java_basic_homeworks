package ru.otus.https.server;

public class Application {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8189);
        httpServer.start();
    }
}

