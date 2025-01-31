package ru.otus.https.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8189);
        httpServer.start();
    }
}

